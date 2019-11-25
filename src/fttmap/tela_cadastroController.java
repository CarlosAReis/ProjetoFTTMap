/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Caue
 */
public class tela_cadastroController implements Initializable {
    
    @FXML
    private ComboBox<String> cbCurso;
    @FXML
    private BorderPane pane;
    private int cadastrado = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Carregar();
    }
    public void Carregar(){
        
        cbCurso.getItems().add("EC");
        cbCurso.getItems().add("ECA"); 
        cbCurso.getItems().add("EAL");
        cbCurso.getItems().add("ADM");
        
    }
    @FXML
    void btnRegistrarAction() {
        Dialog dialog = new Dialog();
        if(cadastrado == 0){
            dialog.setContentText("Registrado");
            cadastrado = 1;
        }
        else{
            dialog.setContentText("ERRO, ALUNO JÁ CADASTRADO");
            cadastrado =0;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        Node closeButton = dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);
        dialog.showAndWait();
    }
   
//    @FXML
//    private void closeButtonAction()  {
//        Stage stage  = (Stage) pane.getScene().getWindow();
//        stage.close();
//    }
}
