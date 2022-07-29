package app.project.FranchiseMicroservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @JsonFormat(pattern="HH:mm:ss")
    @Column(name = "time", nullable = false)
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "payment",nullable = false)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "card",nullable = false)
    private Card card;
    @Column(name = "total", nullable = false)
    private Float total;
}
