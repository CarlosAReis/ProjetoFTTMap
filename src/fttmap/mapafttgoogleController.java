/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import DAO.Excel;
import Service.ExcelController;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.joda.time.DateTime;

/**
 *
 * @author Caue
 */
public class mapafttgoogleController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        String dayOfWeek = getDate();
            System.out.println("dayOfWeek => " + dayOfWeek);
        String[][] dayMatrix = null;
        
        switch (dayOfWeek) {
            case "Segunda-feira" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.MONDAY);
                break;
            case "Terça-feira" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.TUESDAY);
                break;
            case "Quarta-feira" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.WEDNESDAY);
                break;
            case "Quinta-feira" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.THURSDAY);
                break;
            case "Sexta-feira" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.FRIDAY);
                break;
            case "Sábado" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.SATURDAY);
                break;
        }
        
        if (dayMatrix != null) {
            DateTime now = new DateTime();
//            System.out.println("now.getHourOfDay() => " + now.getHourOfDay());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            String today = sdf.format(new Date());
//            System.out.println("today => " + today);
            
            String numeroSala = "";
            SimpleDateFormat parser = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
            
            for (Integer i = 0; i < 4; i++) {
//            System.out.println("dayMatrix[i][Excel.horaInicio] => " + dayMatrix[i][Excel.horaInicio]);
                Date timeBegin = null;
                try {
                    timeBegin = parser.parse(today + " " + dayMatrix[i][Excel.horaInicio] + ":00");
//                    System.out.println("timeBegin => " + timeBegin.toString());
                } catch (ParseException ex) {
                    Logger.getLogger(mapafttgoogleController.class.getName()).log(Level.SEVERE, null, ex);
                }
//            System.out.println("dayMatrix[i][Excel.horaTermino] => " + dayMatrix[i][Excel.horaTermino]);
            
                Date timeEnd = null;
                try {
                    timeEnd = parser.parse(today + " " + dayMatrix[i][Excel.horaTermino] + ":00");
//                    System.out.println("timeEnd => " + timeEnd.toString());
                } catch (ParseException ex) {
                    Logger.getLogger(mapafttgoogleController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (timeBegin != null && timeEnd != null) {
//            System.out.println("now => " + now.toString());
                    if (now.isBefore(timeBegin.getTime())) {
                        numeroSala = dayMatrix[i][Excel.sala];
                        break;
                    } else if (now.isBefore(timeEnd.getTime())) {
                        numeroSala = dayMatrix[i][Excel.sala];
                        break;
                    }
                }
            }
            System.out.println("numeroSala => " + numeroSala);
            
//            BackgroundFill backgroundFill2 = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
//            Background bg2 = new Background(backgroundFill2);
//            pn81.setBackground(bg2);
            
            if (!numeroSala.isEmpty()) {
                Pane pn = getClassroomPaneInstance(numeroSala);
                if (pn != null) {
                    BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
                    Background bg = new Background(backgroundFill);
                    pn.setBackground(bg);
                    getBlocoPaneByClassroomNumber(numeroSala).setVisible(true);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "O bloco para a sala " + numeroSala + " não está implementado!", ButtonType.OK);
                    alert.showAndWait();
                }
            }
        }
        
    }
    
 
    public static String getDate() {
 
        Date now = new Date();
 
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
//        System.out.println(simpleDateformat.format(now));
 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return simpleDateformat.format(now);
 
    }
    
    @FXML
    private Button btnBloco1;
    @FXML
    private Pane pnBloco1;
    @FXML
    private Button btnBloco2;
    @FXML
    private Pane pnBloco2;
    @FXML
    private Button btnBloco3;
    @FXML
    private Pane pnBloco3;
    @FXML
    private Button btnBloco4;
    @FXML
    private Pane pnBloco4;
    @FXML
    private Button btnBloco5;
    @FXML
    private Pane pnBloco5;
    @FXML
    private Button btnBloco6;
    @FXML
    private Pane pnBloco6;
    @FXML
    private Button btnBloco7;
    @FXML
    private Pane pnBloco7;
    @FXML
    private Button btnBloco8;
    @FXML
    private Pane pnBloco8;
    @FXML
    private Button btnBloco9;
    @FXML
    private Pane pnBloco9;
    @FXML
    private Button btnFTT;
    @FXML
    private Pane pnFTT;
    
    private Pane getBlocoPaneByClassroomNumber(String number) {
        
        if (Integer.valueOf(number) > 73 && Integer.valueOf(number) < 89) {
            return pnFTT;
        }
        return null;
    }
    
    private Pane getClassroomPaneInstance(String number) {
        
        switch (number) {
            case "74":
                return pn74;
            case "75":
                return pn75;
            case "76":
                return pn76;
            case "77":
                return pn77;
            case "78":
                return pn78;
            case "79":
                return pn79;
            case "80":
                return pn80;
            case "81":
                return pn81;
            case "82":
                return pn82;
            case "83":
                return pn83;
            case "84":
                return pn84;
            case "85":
                return pn85;
            case "87":
                return pn87;
            case "88":
                return pn88;
        }
        return null;
    }
    
    @FXML
    private Pane pn74;
    @FXML
    private Pane pn75;
    @FXML
    private Pane pn76;
    @FXML
    private Pane pn77;
    @FXML
    private Pane pn78;
    @FXML
    private Pane pn79;
    @FXML
    private Pane pn80;
    @FXML
    private Pane pn81;
    @FXML
    private Pane pn82;
    @FXML
    private Pane pn83;
    @FXML
    private Pane pn84;
    @FXML
    private Pane pn85;
    @FXML
    private Pane pn87;
    @FXML
    private Pane pn88;
    
    void setAllNotVisible() {
        pnBloco1.setVisible(false);
        pnBloco2.setVisible(false);
        pnBloco3.setVisible(false);
        pnBloco4.setVisible(false);
        pnBloco5.setVisible(false);
        pnBloco6.setVisible(false);
        pnBloco7.setVisible(false);
        pnBloco8.setVisible(false);
        pnBloco9.setVisible(false);
        pnFTT.setVisible(false);
    }
    
    @FXML
    void onBloco1Click() {
        setAllNotVisible();
        pnBloco1.setVisible(true);
    }
    
    @FXML
    void onBloco2Click() {
        setAllNotVisible();
        pnBloco2.setVisible(true);
    }
    
    @FXML
    void onBloco3Click() {
        setAllNotVisible();
        pnBloco3.setVisible(true);
    }
    
    @FXML
    void onBloco4Click() {
        setAllNotVisible();
        pnBloco4.setVisible(true);
    }
    
    @FXML
    void onBloco5Click() {
        setAllNotVisible();
        pnBloco5.setVisible(true);
    }
    
    @FXML
    void onBloco6Click() {
        setAllNotVisible();
        pnBloco6.setVisible(true);
    }
    
    @FXML
    void onBloco7Click() {
        setAllNotVisible();
        pnBloco7.setVisible(true);
    }
    
    @FXML
    void onBloco8Click() {
        setAllNotVisible();
        pnBloco8.setVisible(true);
    }
    
    @FXML
    void onBloco9Click() {
        setAllNotVisible();
        pnBloco9.setVisible(true);
    }
    
    @FXML
    void onBlocoFTTClick() {
        setAllNotVisible();
        pnFTT.setVisible(true);
    }
    
}
