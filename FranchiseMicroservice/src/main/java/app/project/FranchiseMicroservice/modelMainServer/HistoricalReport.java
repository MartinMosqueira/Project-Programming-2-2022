package app.project.FranchiseMicroservice.modelMainServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalReport {
    public String accion;
    public List<VentaDetalleOut> datos;
}
