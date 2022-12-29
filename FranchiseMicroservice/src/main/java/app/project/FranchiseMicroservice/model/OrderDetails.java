package app.project.FranchiseMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @Column(name = "ventaId", unique = true, nullable = false)
    private String ventaId;
    @ManyToOne
    @JoinColumn(name = "orden", nullable = false)
    private Orders orden;
    @ManyToOne
    @JoinColumn(name = "menu", nullable = false)
    private Menu menu;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precio", nullable = false)
    private Float precio;
}
