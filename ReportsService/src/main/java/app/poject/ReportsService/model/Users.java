package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private LocalDate nacimiento;
}
