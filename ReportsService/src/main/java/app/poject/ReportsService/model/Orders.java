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
    private Users usuario;
    private Instant fecha;
    private Payment pago;
    private Card tarjeta;
    private Float total;
}
