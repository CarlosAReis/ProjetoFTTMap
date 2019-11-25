/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import Controllers.ComunsController;
import VO.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Caue
 */
public class tela_perfilController implements Initializable {
      
    private Usuario CurrentUser;
    @FXML
    private ComboBox<String> cbCurso; 
    
    @FXML
    private PasswordField tbSenha;
    
    @FXML
    private TextField tbRA;
     
    @FXML
    private TextField tbNome;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        CurrentUser = Usuario.getCurrentUser();
        if(CurrentUser.getCategoria().equals("Comum")){
            cbCurso.getItems().add(CurrentUser.getCurso());
            cbCurso.setValue(CurrentUser.getCurso());
        }
        else{
            cbCurso.setEditable(false);
            cbCurso.getItems().add("Todos");
            cbCurso.setValue("Todos");
        }
        tbSenha.setText(CurrentUser.getDecriptedPassword());
        tbRA.setText(CurrentUser.getRA());
        tbNome.setText(CurrentUser.getNome());
        
    }
    @FXML
    void onActionAtualizarSenha() throws IOException{
        Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
       
        if(alterarSenha()){
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Senha Alterada");
        }
        else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Senha deve estar entre 4 e 8 caracteres!");
        }
        alert.showAndWait();
       
    }
    
    private boolean alterarSenha(){
        return ComunsController.atualizarAluno(CurrentUser, tbSenha.getText());
    }
}
