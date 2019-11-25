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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private TextField tbRA;
    
    @FXML
    private TextField tbNome;
    
    @FXML
    private PasswordField tbSenha;
    @FXML
    private BorderPane pane;

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
        Usuario user = new Usuario();
        user.setRA(tbRA.getText());
        user.setNome(tbNome.getText());
        user.setSenha(tbSenha.getText());
        user.setCategoria("Comum");
        user.setCurso(cbCurso.getValue());
        user.setSemestre(1);
        if(!ComunsController.VerifyCourse(cbCurso.getValue())){
            dialog.setContentText("Selecione um curso");
        }
        else if(!ComunsController.VerifyName(user.getNome())){
            dialog.setContentText("Nome deve estar entre 3 e 20 caracteres");
        }
        else if(!ComunsController.VerifyPassword(user.getSenha())){
             dialog.setContentText("Senha deve estar entre 4 e 8 caracteres");
        }
        else if(!ComunsController.VerifyRA(user.getRA())){
              dialog.setContentText("RA deve estar entre 4 e 20 caracteres");
        }
        else if(ComunsController.cadastrarAluno(user)){
                dialog.setContentText("Aluno Cadastrado");
        }
        else{
            dialog.setContentText("ERRO, ALUNO JÁ CADASTRADO");
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        Node closeButton = dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);
        dialog.showAndWait();
    }
   
    @FXML
    private void closeButtonAction()  {
        Stage stage  = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
