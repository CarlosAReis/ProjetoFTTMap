/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fttmap;

import Config.Config;
import Controllers.ComunsController;
import Enums.Repositories;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author jojok
 */
public class FTTMap extends Application {
    
    @Override
    public void start(final Stage stage) throws IOException {
//         Excel.write();
        
        Config.getInstance().setDatabase(Repositories.MYSQL);
        final Parent root = FXMLLoader.load(getClass().getResource("tela_login.fxml"));

        final Scene scene = new Scene(root);
        
        stage.getIcons().add(new Image("file:" + new File(".").getCanonicalPath() + "\\src\\images\\tm_logo.png"));

        stage.setScene(scene);
        stage.show();
        ComunsController.verifyDatabase();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
    
}
