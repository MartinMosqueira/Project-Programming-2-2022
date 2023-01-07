package app.project.FranchiseMicroservice.modelMainServer;

import app.project.FranchiseMicroservice.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalReport {
    public String accion;
    public List<OrderDetails> datos;
}
