package app.project.FranchiseMicroservice.model.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venta")
public class Venta {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @Column(name = "venta_id", nullable = false)
    private UUID ventaId;
    @Column(name = "fecha", nullable = false)
    private Instant fecha;
    @ManyToOne
    @JoinColumn(name = "pago",nullable = false)
    private Pago pago;
    @ManyToOne
    @JoinColumn(name = "tarjeta")
    private Tarjeta tarjeta;
    @Column(name = "total", nullable = false)
    private Double total;

    /*
    @PrePersist
    public void prePersistFechaNow(){
        fecha = fecha.plus(3, ChronoUnit.HOURS);
    }

    @PreUpdate
    public void preUpdateFechaNow(){
        fecha = fecha.plus(3, ChronoUnit.HOURS);
    }

     */
}
