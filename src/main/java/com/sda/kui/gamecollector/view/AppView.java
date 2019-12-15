package com.sda.kui.gamecollector.view;

import com.sda.kui.gamecollector.services.GameService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class AppView extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        GameService gameService = new GameService();

        primaryStage.setTitle("Game Collector");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        Button button = new Button("Add new Game");


        HBox hBox = new HBox();

        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(hBox);



        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


}
