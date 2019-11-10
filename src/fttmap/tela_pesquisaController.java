/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Caue
 */
public class tela_pesquisaController implements Initializable {
    
    @FXML
    private ComboBox<String> cbTipo;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipo.getItems().add("Matéria");
        cbTipo.getItems().add("Professor");
    }
    
}
