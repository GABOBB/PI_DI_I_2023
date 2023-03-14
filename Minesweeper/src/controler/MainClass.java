/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controler;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *  esta clase es la responslabe de de iniciar 
 *  la ejecucion y cargar la ventana
 * @author GBB
 */
public class MainClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("/visual/Main_FXML.fxml"));
            Pane ventana = (Pane) loader.load();//se carga la ventana
            Scene scene = new Scene(ventana);//se carga la escena
            primaryStage.setScene(scene);//se setea la escena
            primaryStage.show();//se ense;a la escena
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
