package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("ORACLE DATABASE");
        primaryStage.setScene(new Scene(root, 800, 600));
        Connector connector = new Connector("wpatryk","wpatryk123");
        Controller controller = loader.getController();
        if (controller == null) {
            System.out.println("null");
        } else {
            controller.loadUpTheUsers(connector);
        }
        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);
    }
}
