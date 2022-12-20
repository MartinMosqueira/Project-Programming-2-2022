package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Long id;
    private Users users;
    private Instant date;
    private Payment payment;
    private Card card;
    private Float total;
}
