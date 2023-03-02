package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalle {
    private Long id;
    private Venta venta;
    private Menu menu;
    private Integer cantidad;
    private Double precio;
}
