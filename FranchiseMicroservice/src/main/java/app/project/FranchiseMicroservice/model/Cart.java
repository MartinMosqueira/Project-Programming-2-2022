package app.project.FranchiseMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Users usuario;
    @ManyToOne
    @JoinColumn(name = "menu", nullable = false)
    private Menu menu;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
}
