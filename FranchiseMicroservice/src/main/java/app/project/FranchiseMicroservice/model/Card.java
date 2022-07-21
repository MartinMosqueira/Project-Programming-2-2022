package app.project.FranchiseMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;
    @Column(name = "number", nullable = false)
    private Long number;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "expiration", nullable = false)
    private LocalDate expiration;
    @Column(name = "code", nullable = false)
    private Integer code;
    @Column(name = "dni", nullable = false)
    private Long dni;
    @OneToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
