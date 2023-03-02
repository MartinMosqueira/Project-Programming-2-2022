package app.project.FranchiseMicroservice.model.postgres;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @Column(name = "numero", nullable = false)
    private Long numero;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "vencimiento", nullable = false)
    private LocalDate vencimiento;
    @OneToOne
    @JoinColumn(name = "compania", nullable = false)
    private Compania compania;
}
