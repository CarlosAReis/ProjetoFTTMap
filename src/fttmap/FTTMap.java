/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;
import Enums.Repositories;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jojok
 */
public class FTTMap extends Application {
    
    @Override
    public void start(final Stage stage) throws IOException {
        
        Config.Config.getInstance().setDatabase(Repositories.MYSQL);
        Parent root = FXMLLoader.load(getClass().getResource("tela_login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
    
}
