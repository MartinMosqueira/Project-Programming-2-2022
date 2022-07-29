package app.project.FranchiseMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
    @JoinColumn(name = "users", nullable = false)
    private Users users;
    @ManyToOne
    @JoinColumn(name = "menu", nullable = false)
    private Menu menu;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
