package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private Long id;
    private UUID ventaId;
    private Instant fecha;
    private Pago pago;
    private Tarjeta tarjeta;
    private Double total;
}
