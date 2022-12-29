package app.project.FranchiseMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    private Users usuario;
    @Column(name = "fecha", nullable = false)
    private Instant fecha;
    @ManyToOne
    @JoinColumn(name = "pago",nullable = false)
    private Payment pago;
    @ManyToOne
    @JoinColumn(name = "tarjeta")
    private Card tarjeta;
    @Column(name = "total", nullable = false)
    private Float total;
}
