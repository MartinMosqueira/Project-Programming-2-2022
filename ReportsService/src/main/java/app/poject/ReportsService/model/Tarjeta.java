package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta {
    private Long id;
    private Long numero;
    private String nombre;
    private LocalDate vencimiento;
    private Compania compania;
}
