package app.poject.ReportsService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String urlImagen;
    private Boolean activo;
    private Instant creado;
    private Instant actualizado;
}
