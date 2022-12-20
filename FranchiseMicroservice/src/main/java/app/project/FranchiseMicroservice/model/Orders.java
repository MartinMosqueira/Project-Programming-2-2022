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
    @JoinColumn(name = "users",nullable = false)
    private Users users;
    @Column(name = "date", nullable = false)
    private Instant date;
    @ManyToOne
    @JoinColumn(name = "payment",nullable = false)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "card")
    private Card card;
    @Column(name = "total", nullable = false)
    private Float total;
}
