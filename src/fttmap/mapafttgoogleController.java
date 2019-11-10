/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Caue
 */
public class mapafttgoogleController {
    
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
