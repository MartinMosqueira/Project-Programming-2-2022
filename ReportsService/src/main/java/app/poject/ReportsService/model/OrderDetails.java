package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Long id;
    private String ventaId;
    private Orders orden;
    private Menu menu;
    private Integer cantidad;
    private Float precio;
}
