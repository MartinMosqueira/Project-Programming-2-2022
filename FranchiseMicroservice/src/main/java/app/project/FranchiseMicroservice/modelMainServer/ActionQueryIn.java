package app.project.FranchiseMicroservice.modelMainServer;

import app.project.FranchiseMicroservice.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionQueryIn {
    private String accion;
    //NOTE: changes the attributes in menus with the same name as in the main server.
    private List<Menu> menus;
}
