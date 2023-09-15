package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	MyView view = new MyView();
        view.start(primaryStage);

    }
}

