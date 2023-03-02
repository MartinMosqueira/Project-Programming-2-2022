package app.project.FranchiseMicroservice.repo.postgres;

import app.project.FranchiseMicroservice.model.postgres.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface IVentaDetalleRepo extends JpaRepository<VentaDetalle, Long> {

    List<VentaDetalle> findAllByVentaFechaBetween(Instant fecha1, Instant fecha2);
}
