package com.sda.kui.gamecollector.view;

import com.sda.kui.gamecollector.dao.GameDao;
import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.services.GameService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;


public class AppView extends Application {

    GameDao gameDao = new GameDao();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameService gameService = new GameService();

        primaryStage.setTitle("Game Collector");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        Label gameName = new Label("Name:");
        TextField nameTextField = new TextField();
        VBox vBoxName = new VBox();
        vBoxName.getChildren().addAll(gameName, nameTextField);

        Label gameStatus = new Label("Status:");
        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList("New", "PLaying", "Finished"));
        vBoxName.getChildren().addAll(gameStatus, choiceBox);

        Label gamePlatform = new Label("Platform");
        TextField platformTextField = new TextField();
        vBoxName.getChildren().addAll(gamePlatform, platformTextField);

        Label gamePublisher = new Label("Publisher:");
        TextField publisherTextField = new TextField();
        vBoxName.getChildren().addAll(gamePublisher, publisherTextField);

        Label gameStudio = new Label("Studio:");
        TextField studioTextField = new TextField();
        vBoxName.getChildren().addAll(gameStudio, studioTextField);

        Label gameTag = new Label("Tag:");
        TextField tagTextField = new TextField();
        vBoxName.getChildren().addAll(gameTag, tagTextField);

        vBoxName.setFillWidth(false);


        ListView<Game> gameListView = new ListView<>();
        ObservableList<Game> games = FXCollections.observableList(gameDao.getAllGames());
        gameListView.setItems(games);
        VBox vBoxList = new VBox();
        vBoxList.getChildren().add(gameListView);
        vBoxList.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxList.setFillWidth(false);

        Button button = new Button("Add new Game");
        HBox hBoxButton = new HBox();
        hBoxButton.getChildren().add(button);
        hBoxButton.setAlignment(Pos.BASELINE_LEFT);


        VBox vBox = new VBox();

        vBox.getChildren().addAll(vBoxName, hBoxButton, vBoxList);
//        vBox.setAlignment(Pos.CENTER);



        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


}
