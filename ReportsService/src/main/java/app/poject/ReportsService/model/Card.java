package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private Long numero;
    private String nombre;
    private LocalDate vencimiento;
    private Integer codigo;
    private Long dni;
    private Company compania;
    private Users usuario;
}
