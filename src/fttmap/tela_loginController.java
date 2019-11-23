/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import Controllers.Acesso;
import Controllers.LoginController;
import VO.Usuario;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;



/**
 *
 * @author Caue
 */
public class tela_loginController {
    
    private final Stage stage = new Stage();
    private boolean logado;
    
    @FXML
    private void btnEntrar_Click(javafx.scene.input.MouseEvent event) throws IOException {
        
        DoLogin(false);
        // PODE SER ISSO
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(stage.getScene().getWindow());
//        stage.setScene(scene);
//        stage.show();
    }
    @FXML
    private void btnEntrarADM_Click(javafx.scene.input.MouseEvent event) throws IOException {
        
        DoLogin(true);
    }
    
    @FXML
    private void btnSair_Click(javafx.scene.input.MouseEvent event) throws IOException {
        Platform.exit();
    }
    private Usuario GetUser(){
        Usuario user = new Usuario();
        //user.setUsername(txt.getText());
        //user.setSenha(txtSenha.getText());
        Acesso acesso = new Acesso();
        logado =  acesso.validaUsuarioAdmin(user);
        stage.close();
        
        return user;
    }
    private void ShowMenu() throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void ShowErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Usuário/Senha inválido", ButtonType.OK);
        alert.showAndWait();
    }
    
    private void DoLogin(boolean asAdmin) throws IOException{
        
        logado = true;//LoginController.DoLogin(asAdmin, GetUser());
        
        if(logado){
           ShowMenu();
        }
        else{
            ShowErrorMessage();
        }
    }
    
}
