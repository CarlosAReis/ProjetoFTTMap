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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Caue
 */
public class menuController implements Initializable {
    
     @FXML
    private ComboBox<String> cbSemestre;

    @FXML
    private Button btnMapa;

    @FXML
    private Button btnDesconectar;
    
    @FXML
    private Button btnCadastrarAluno;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnPesquisar;
    
    @FXML
    private BorderPane pane;
    
    @FXML
    void onActionMapa() throws IOException {
         
        Parent root = FXMLLoader.load(getClass().getResource("mapafttgoogle.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void onActionCadastrarAluno() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_cadastro.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionPerfil() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_perfil.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionPesquisar() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tela_pesquisa.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionDesconectar() {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente sair ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            Stage stage  = (Stage) pane.getScene().getWindow();
            stage.close();
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        cbSemestre.getItems().add("1º");
        cbSemestre.getItems().add("2º");
        cbSemestre.getItems().add("3º");
        cbSemestre.getItems().add("4º");
        cbSemestre.getItems().add("5º");
        cbSemestre.getItems().add("6º");
        cbSemestre.getItems().add("7º");
        cbSemestre.getItems().add("8º");
        cbSemestre.getItems().add("9º");
        cbSemestre.getItems().add("10º");
        
    }
    
    
}
