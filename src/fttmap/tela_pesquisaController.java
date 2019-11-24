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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Caue
 */
public class tela_pesquisaController implements Initializable {
    
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        cbTipo.getItems().add("Matéria");
        cbTipo.getItems().add("Professor");
        
        String[][] matrixSEG = ExcelController.getDayMatrix(Excel.Day.MONDAY);
        String[][] matrixTER = ExcelController.getDayMatrix(Excel.Day.TUESDAY);
        String[][] matrixQUA = ExcelController.getDayMatrix(Excel.Day.WEDNESDAY);
        String[][] matrixQUI = ExcelController.getDayMatrix(Excel.Day.THURSDAY);
        String[][] matrixSEX = ExcelController.getDayMatrix(Excel.Day.FRIDAY);
        
        Label lbSEG1 = new Label(matrixSEG[0][1]);
        System.out.println(lbSEG1.toString());
        pnSEG1 = new Pane(lbSEG1);
        
        Label lbSEG2 = new Label(matrixSEG[1][1]);
        System.out.println(lbSEG2.toString());
        pnSEG2 = new Pane(lbSEG2);
        
        Label lbSEG3 = new Label(matrixSEG[2][1]);
        System.out.println(lbSEG3.toString());
        pnSEG3 = new Pane(lbSEG3);
        
        Label lbSEG4 = new Label(matrixSEG[3][1]);
        pnSEG4 = new Pane(lbSEG4);
        
        Label lbTER1 = new Label(matrixTER[0][1]);
        pnTER1 = new Pane(lbTER1);
        
        Label lbTER2 = new Label(matrixTER[1][1]);
        pnTER2 = new Pane(lbTER2);
        
        Label lbTER3 = new Label(matrixTER[2][1]);
        pnTER3 = new Pane(lbTER3);
        
        Label lbTER4 = new Label(matrixTER[3][1]);
        pnTER4 = new Pane(lbTER4);
        
        Label lbQUA1 = new Label(matrixQUA[0][1]);
        pnQUA1 = new Pane(lbQUA1);
        
        Label lbQUA2 = new Label(matrixQUA[1][1]);
        pnQUA2 = new Pane(lbQUA2);
        
        Label lbQUA3 = new Label(matrixQUA[2][1]);
        pnQUA3 = new Pane(lbQUA3);
        
        Label lbQUA4 = new Label(matrixQUA[3][1]);
        pnQUA4 = new Pane(lbQUA4);
        
        Label lbQUI1 = new Label(matrixQUI[0][1]);
        pnQUI1 = new Pane(lbQUI1);
        
        Label lbQUI2 = new Label(matrixQUI[1][1]);
        pnQUI2 = new Pane(lbQUI2);
        
        Label lbQUI3 = new Label(matrixQUI[2][1]);
        pnQUI3 = new Pane(lbQUI3);
        
        Label lbQUI4 = new Label(matrixQUI[3][1]);
        pnQUI4 = new Pane(lbQUI4);
        
        Label lbSEX1 = new Label(matrixSEX[0][1]);
        pnSEX1 = new Pane(lbSEX1);
        
        Label lbSEX2 = new Label(matrixSEX[1][1]);
        pnSEX2 = new Pane(lbSEX2);
        
        Label lbSEX3 = new Label(matrixSEX[2][1]);
        pnSEX3 = new Pane(lbSEX3);
        
        Label lbSEX4 = new Label(matrixSEX[3][1]);
        pnSEX4 = new Pane(lbSEX4);
        
        String[][] matrixSAB = ExcelController.getDayMatrix(Excel.Day.SATURDAY);
        if (matrixSAB != null) {
            Label lbSAB1 = new Label(matrixSAB[0][1]);
            pnSAB1 = new Pane(lbSAB1);

            Label lbSAB2 = new Label(matrixSAB[1][1]);
            pnSAB2 = new Pane(lbSAB2);

            Label lbSAB3 = new Label(matrixSAB[2][1]);
            pnSAB3 = new Pane(lbSAB3);

            Label lbSAB4 = new Label(matrixSAB[3][1]);
            pnSAB4 = new Pane(lbSAB4);
        }
    }
    
}
