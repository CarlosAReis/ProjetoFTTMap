/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;

/**
 *
 * @author Caue
 */
public class mapafttController implements Initializable {
     @FXML
    private Button btnSala82;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
          Tooltip tt = new Tooltip();
        tt.setText("Text on Hover");
        tt.setStyle("-fx-font: normal bold 24 Langdon; "
        + "-fx-base: #AE3522; "
        + "-fx-text-fill: orange;");

        btnSala82.setTooltip(tt);
    }
     @FXML
    void mouseClicked() {
       
    }

    @FXML
    void mouseEntered() {
    
    }

    @FXML
    void mouseExited() {

    }

}
