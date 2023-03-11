package app.poject.ReportsService.modelMainServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDetalleOut {
    private UUID ventaId;
    private Instant fecha;
    private Long menu;
    private Double precio; //NOTE: change precio Float to Double
}
