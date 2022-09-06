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
    private Long number;
    private String name;
    private LocalDate expiration;
    private Integer code;
    private Long dni;
    private Company company;
    private Users users;
}
