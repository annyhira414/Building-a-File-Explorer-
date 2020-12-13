package workapplicationfx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;



public class ControllerThemView implements Initializable {
    @FXML private TilePane tilePane;
    public static FileControllerFx Fx3;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Fx3 = new ClassWorkingTiteView();
        Fx3.tilePane = tilePane;
        Fx3.CreateTiles();
    }
}
