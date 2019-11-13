/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 *
 * @author Caue
 */
public class tela_loginController {
    
    private final Stage stage = new Stage();
    @FXML
    private void btnEntrar_Click(javafx.scene.input.MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        // PODE SER ISSO
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(stage.getScene().getWindow());
//        stage.setScene(scene);
//        stage.show();
    }
    @FXML
    private void btnEntrarADM_Click(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void btnSair_Click(javafx.scene.input.MouseEvent event) throws IOException {
        Platform.exit();
    }
}
