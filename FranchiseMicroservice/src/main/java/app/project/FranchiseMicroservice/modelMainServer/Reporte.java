package app.project.FranchiseMicroservice.modelMainServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte {
    private Long id;
    private String tipo;
    private Instant fechaInicio;
    private Instant fechaFin;
    private String intervalo;
}
