package app.project.FranchiseMicroservice.model.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venta_detalle")
public class VentaDetalle {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "venta", nullable = false)
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "menu", nullable = false)
    private Menu menu;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precio", nullable = false)
    private Double precio;
}
