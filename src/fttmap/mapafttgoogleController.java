/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import DAO.Excel;
import Service.ExcelController;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Caue
 */
public class mapafttgoogleController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        String dayOfWeek = getDate();
        String[][] dayMatrix = null;
        
        switch (dayOfWeek) {
            case "Monday" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.MONDAY);
                break;
            case "Tuesday" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.TUESDAY);
                break;
            case "Wednesday" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.WEDNESDAY);
                break;
            case "Thursday" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.THURSDAY);
                break;
            case "Friday" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.FRIDAY);
                break;
            case "Saturday" :
                dayMatrix = ExcelController.getDayMatrix(Excel.Day.SATURDAY);
                break;
        }
        
        if (dayMatrix != null) {
            Calendar now = Calendar.getInstance();
            now.get(Calendar.HOUR_OF_DAY);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            
            String today = sdf.format(new Date());
            
            String numeroSala = "";
            
            for (Integer i = 0; i < 4; i++) {
                SimpleDateFormat timeBegin = new SimpleDateFormat(today + " " + dayMatrix[i][Excel.horaInicio] + ":00");
                SimpleDateFormat timeEnd = new SimpleDateFormat(today + " " + dayMatrix[i][Excel.horaTermino] + ":00");
                if (now.before(timeBegin)) {
                    numeroSala = dayMatrix[i][Excel.sala];
                    break;
                } else if (now.before(timeEnd)) {
                    numeroSala = dayMatrix[i][Excel.sala];
                    break;
                }
            }
            
            // get panel with classroom number
        }
        
    }
    
 
    public static String getDate() {
 
        Date now = new Date();
 
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
//        System.out.println(simpleDateformat.format(now));
 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return simpleDateformat.format(now);
 
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format
 
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
