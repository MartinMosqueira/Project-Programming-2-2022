package app.project.FranchiseMicroservice.modelMainServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionQueryOut {
    private String accion;
    private String franquiciaID;
}
