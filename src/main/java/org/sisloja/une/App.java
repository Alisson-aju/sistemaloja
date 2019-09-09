package org.sisloja.une;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {

    }



    /**
     * Carrega uma view .fxml e gera um Parent node
     * @param absolutePath
     * @return Parent node a partir do FXML
     */
    private static Parent loadFXML(String absolutePath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(absolutePath));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}