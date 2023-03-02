package app.project.FranchiseMicroservice.model.h2;

import app.project.FranchiseMicroservice.model.postgres.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private MenuC menu;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
}
