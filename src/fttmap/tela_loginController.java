/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import Controllers.Acesso;
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
        
        doLogin(false);
        // PODE SER ISSO
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initOwner(stage.getScene().getWindow());
//        stage.setScene(scene);
//        stage.show();
    }
    @FXML
    private void btnEntrarADM_Click(javafx.scene.input.MouseEvent event) throws IOException {
        
        doLogin(true);
    }
    
    @FXML
    private void btnSair_Click(javafx.scene.input.MouseEvent event) throws IOException {
        Platform.exit();
    }
    private Usuario getUser(){
        Usuario user = new Usuario();
        //user.setUsername(txt.getText());
        //user.setSenha(txtSenha.getText());
        Acesso acesso = new Acesso();
        logado =  acesso.validaUsuarioAdmin(user);
        stage.close();
        
        return user;
    }
    private void showMenu() throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Usuário/Senha inválido", ButtonType.OK);
        alert.showAndWait();
    }
    
    private void doLogin(boolean asAdmin) throws IOException{
        
        showMenu();
        /*
        logado =  LoginController.doLogin(asAdmin, getUser());
=======
        logado = true;//LoginController.DoLogin(asAdmin, GetUser());
>>>>>>> 82af0a181ac6ffa4b5246b7ced9636bb88232507
        
        if(logado){
           showMenu();
        }
        else{
            showErrorMessage();
        }
                */
    }
    
}
