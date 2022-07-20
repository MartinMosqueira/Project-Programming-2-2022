package app.project.FranchiseMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "number",unique = true, nullable = false)
    private Long number;
    @Column(name = "name",unique = true, nullable = false)
    private String name;
    @Column(name = "expiration",unique = true, nullable = false)
    private Date expiration;
    @Column(name = "code",unique = true, nullable = false)
    private Integer code;
    @Column(name = "dni",unique = true, nullable = false)
    private Long dni;
    @OneToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
