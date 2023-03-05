package app.project.FranchiseMicroservice.service.memory;

import app.project.FranchiseMicroservice.model.h2.Carrito;
import app.project.FranchiseMicroservice.model.postgres.*;
import app.project.FranchiseMicroservice.repo.h2.ICarritoRepo;
import app.project.FranchiseMicroservice.repo.postgres.ICompaniaRepo;
import app.project.FranchiseMicroservice.repo.postgres.IPagoRepo;
import app.project.FranchiseMicroservice.repo.postgres.ITarjetaRepo;
import app.project.FranchiseMicroservice.service.PagoService;
import app.project.FranchiseMicroservice.service.TarjetaService;
import app.project.FranchiseMicroservice.service.VentaDetalleService;
import app.project.FranchiseMicroservice.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarritoService {
    @Autowired
    private ICarritoRepo carritoRepo;

    @Autowired
    private PagoCService pagoCService;

    @Autowired
    private TarjetaCService tarjetaCService;

    @Autowired
    private ICompaniaRepo companiaRepo;

    @Autowired
    private IPagoRepo pagoRepo;

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private VentaDetalleService ventaDetalleService;

    public Carrito create_carrito_service(Carrito carrito){
        return carritoRepo.save(carrito);
    }

    public List<Carrito> get_all_carrito_service(){
        return carritoRepo.findAll();
    }

    public void delete_carrito_service(Long id){
        carritoRepo.deleteById(id);
    }

    public void delete_all_carrito_service(){
        carritoRepo.deleteAll();
    }

    public void update_carrito_service(Long id, Carrito carrito){
        Optional<Carrito> getCarrito=this.carritoRepo.findById(id);
        Carrito carritoSelect =getCarrito.get();
        carritoSelect.setMenu(carrito.getMenu());
        carritoSelect.setCantidad(carrito.getCantidad());

        this.carritoRepo.save(carritoSelect);
    }

    public void cancel_buy_carrito_service(){
        pagoCService.delete_pago_carrito_service();
        if (tarjetaCService.get_tarjeta_carrito_service().size() > 0){
            tarjetaCService.delete_tarjeta_carrito_service();
        }
    }

    public void buy_carrito_service(){
        Tarjeta tarjeta = new Tarjeta();
        Compania compania = new Compania();
        Pago pago = new Pago();
        Menu menu = new Menu();
        Venta venta = new Venta();
        VentaDetalle ventaDetalle = new VentaDetalle();
        Double total = 0.0;
        Instant instantNow=Instant.now();

        if (tarjetaCService.get_tarjeta_carrito_service().size() > 0){
            tarjeta.setId(tarjetaService.get_all_card_service().size()+1L);
            tarjeta.setNumero(tarjetaCService.get_tarjeta_carrito_service().get(0).getNumero());
            tarjeta.setNombre(tarjetaCService.get_tarjeta_carrito_service().get(0).getNombre());
            tarjeta.setVencimiento(tarjetaCService.get_tarjeta_carrito_service().get(0).getVencimiento());
            try {
                compania.setId(companiaRepo.findByNombre(tarjetaCService.get_tarjeta_carrito_service().get(0).getCompania()).getId());
                tarjeta.setCompania(compania);
                tarjetaService.create_card_service(tarjeta);
            } catch (NullPointerException e) {
                System.out.println("No existe la compañia");
            }

        }

        for (int i=0; i<this.get_all_carrito_service().size(); i++){
            total+= this.get_all_carrito_service().get(i).getMenu().getPrecio()*this.get_all_carrito_service().get(i).getCantidad();
        }

        venta.setId(ventaService.get_all_venta_service().size()+1L);
        venta.setVentaId(UUID.randomUUID());
        venta.setFecha(instantNow.minus(3, ChronoUnit.HOURS));
        try {
            pago.setId(pagoRepo.findByNombre(pagoCService.get_pago_carrito_service().get(0).getNombre()).getId());
            venta.setPago(pago);
        }catch (NullPointerException e){
            System.out.println("No existe el pago");
        }
        if (tarjetaCService.get_tarjeta_carrito_service().size() > 0){
            venta.setTarjeta(tarjeta);
        }
        venta.setTotal(total);
        ventaService.create_venta_service(venta);

        for (int i=0; i<this.get_all_carrito_service().size(); i++){
            ventaDetalle.setId(ventaDetalleService.get_all_ventaDetalle_service().size()+1L);
            ventaDetalle.setVenta(venta);
            menu.setId(this.get_all_carrito_service().get(i).getMenu().getId());
            ventaDetalle.setMenu(menu);
            ventaDetalle.setCantidad(this.get_all_carrito_service().get(i).getCantidad());
            ventaDetalle.setPrecio(this.get_all_carrito_service().get(i).getMenu().getPrecio());
            ventaDetalleService.create_ventaDetalle_service(ventaDetalle);
        }

        tarjetaCService.delete_tarjeta_carrito_service();
        pagoCService.delete_pago_carrito_service();
        this.delete_all_carrito_service();
    }

}
