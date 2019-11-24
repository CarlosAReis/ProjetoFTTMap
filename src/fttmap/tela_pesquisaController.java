/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import DAO.Excel;
import Service.ExcelController;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Caue
 */
public class tela_pesquisaController implements Initializable {
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        cbTipo.getItems().add("Matéria");
        cbTipo.getItems().add("Professor");
        
        String[][] matrixSEG = ExcelController.getDayMatrix(Excel.Day.MONDAY);
        String[][] matrixTER = ExcelController.getDayMatrix(Excel.Day.TUESDAY);
        String[][] matrixQUA = ExcelController.getDayMatrix(Excel.Day.WEDNESDAY);
        String[][] matrixQUI = ExcelController.getDayMatrix(Excel.Day.THURSDAY);
        String[][] matrixSEX = ExcelController.getDayMatrix(Excel.Day.FRIDAY);
        
        lblSEG1.setText(matrixSEG[0][Excel.disciplina]);
        lblSEG2.setText(matrixSEG[1][Excel.disciplina]);
        lblSEG3.setText(matrixSEG[2][Excel.disciplina]);
        lblSEG4.setText(matrixSEG[3][Excel.disciplina]);
        lblTER1.setText(matrixTER[0][Excel.disciplina]);
        lblTER2.setText(matrixTER[1][Excel.disciplina]);
        lblTER3.setText(matrixTER[2][Excel.disciplina]);
        lblTER4.setText(matrixTER[3][Excel.disciplina]);
        lblQUA1.setText(matrixQUA[0][Excel.disciplina]);
        lblQUA2.setText(matrixQUA[1][Excel.disciplina]);
        lblQUA3.setText(matrixQUA[2][Excel.disciplina]);
        lblQUA4.setText(matrixQUA[3][Excel.disciplina]);
        lblQUI1.setText(matrixQUI[0][Excel.disciplina]);
        lblQUI2.setText(matrixQUI[1][Excel.disciplina]);
        lblQUI3.setText(matrixQUI[2][Excel.disciplina]);
        lblQUI4.setText(matrixQUI[3][Excel.disciplina]);
        lblSEX1.setText(matrixSEX[0][Excel.disciplina]);
        lblSEX2.setText(matrixSEX[1][Excel.disciplina]);
        lblSEX3.setText(matrixSEX[2][Excel.disciplina]);
        lblSEX4.setText(matrixSEX[3][Excel.disciplina]);
        
        String[][] matrixSAB = ExcelController.getDayMatrix(Excel.Day.SATURDAY);
        if (matrixSAB != null) {
            lblSAB1.setText(matrixSAB[0][Excel.disciplina]);
            lblSAB2.setText(matrixSAB[1][Excel.disciplina]);
            lblSAB3.setText(matrixSAB[2][Excel.disciplina]);
            lblSAB4.setText(matrixSAB[3][Excel.disciplina]);
        }
    }
    
    private TextField txtNome;
    
    @FXML
    private void onTextChanged() {
        if (cbTipo.getValue() != null) {
            
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Escolha um tipo!", ButtonType.OK);
            alert.showAndWait();
            txtNome.clear();
        }
    }
    
    @FXML
    private ComboBox<String> cbTipo;
    @FXML
    private Pane pnSEG1;
    @FXML
    private Pane pnSEG2;
    @FXML
    private Pane pnSEG3;
    @FXML
    private Pane pnSEG4;
    @FXML
    private Pane pnTER1;
    @FXML
    private Pane pnTER2;
    @FXML
    private Pane pnTER3;
    @FXML
    private Pane pnTER4;
    @FXML
    private Pane pnQUA1;
    @FXML
    private Pane pnQUA2;
    @FXML
    private Pane pnQUA3;
    @FXML
    private Pane pnQUA4;
    @FXML
    private Pane pnQUI1;
    @FXML
    private Pane pnQUI2;
    @FXML
    private Pane pnQUI3;
    @FXML
    private Pane pnQUI4;
    @FXML
    private Pane pnSEX1;
    @FXML
    private Pane pnSEX2;
    @FXML
    private Pane pnSEX3;
    @FXML
    private Pane pnSEX4;
    @FXML
    private Pane pnSAB1;
    @FXML
    private Pane pnSAB2;
    @FXML
    private Pane pnSAB3;
    @FXML
    private Pane pnSAB4;
    
    @FXML
    private Label lblSEG1;
    @FXML
    private Label lblSEG2;
    @FXML
    private Label lblSEG3;
    @FXML
    private Label lblSEG4;
    @FXML
    private Label lblTER1;
    @FXML
    private Label lblTER2;
    @FXML
    private Label lblTER3;
    @FXML
    private Label lblTER4;
    @FXML
    private Label lblQUA1;
    @FXML
    private Label lblQUA2;
    @FXML
    private Label lblQUA3;
    @FXML
    private Label lblQUA4;
    @FXML
    private Label lblQUI1;
    @FXML
    private Label lblQUI2;
    @FXML
    private Label lblQUI3;
    @FXML
    private Label lblQUI4;
    @FXML
    private Label lblSEX1;
    @FXML
    private Label lblSEX2;
    @FXML
    private Label lblSEX3;
    @FXML
    private Label lblSEX4;
    @FXML
    private Label lblSAB1;
    @FXML
    private Label lblSAB2;
    @FXML
    private Label lblSAB3;
    @FXML
    private Label lblSAB4;
    
}
