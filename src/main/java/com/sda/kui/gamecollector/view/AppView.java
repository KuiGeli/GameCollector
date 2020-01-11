package com.sda.kui.gamecollector.view;

import com.sda.kui.gamecollector.dao.GameDao;
import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.model.Platform;
import com.sda.kui.gamecollector.model.Publisher;
import com.sda.kui.gamecollector.model.Status;
import com.sda.kui.gamecollector.services.GameService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

//todo add search by
//todo add function
public class AppView extends Application {

    GameDao gameDao = new GameDao();

    @Override
    public void start(Stage primaryStage) throws Exception {


        GameService gameService = new GameService();

        primaryStage.setTitle("Game Collector");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        Text title = new Text("GameCollector");
        title.setFont(Font.font("Verenda", 30));
        title.setTextAlignment(TextAlignment.CENTER);

//Elements to add a new game
        Label gameName = new Label("Name:");
        TextField nameTextField = new TextField();
        VBox vBoxName = new VBox();
        vBoxName.getChildren().addAll(gameName, nameTextField);

        Label gameStatus = new Label("Status:");
        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList("NEW", "PLAYING", "FINISHED"));
        VBox vBoxStatus = new VBox();
        vBoxStatus.getChildren().addAll(gameStatus, choiceBox);


        Label gamePlatform = new Label("Platform");
        TextField platformTextField = new TextField();
        VBox vBoxPlatform = new VBox();
        vBoxPlatform.getChildren().addAll(gamePlatform, platformTextField);


        Label gamePublisher = new Label("Publisher:");
        TextField publisherTextField = new TextField();
        VBox vBoxPublisher = new VBox();
        vBoxPublisher.getChildren().addAll(gamePublisher, publisherTextField);


        Label gameStudio = new Label("Studio:");
        TextField studioTextField = new TextField();
        VBox vBoxStudio = new VBox();
        vBoxStudio.getChildren().addAll(gameStudio, studioTextField);

        Label gameTag = new Label("Tag:");
        TextField tagTextField = new TextField();
        VBox vBoxTag = new VBox();
        vBoxTag.getChildren().addAll(gameTag, tagTextField);

        Button button = new Button("Add new Game");
        VBox vBoxButton = new VBox();
        vBoxButton.getChildren().add(button);
        vBoxButton.setAlignment(Pos.BOTTOM_RIGHT);


        vBoxName.setFillWidth(false);



// Elements to search for games

        Label nameSearchLabel = new Label("Search by:");
        ChoiceBox<String> searchChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(
                "Name", "Status", "Platform", "Publisher", "Studio", "Tag"));
        VBox vBoxSearchBy = new VBox();
        vBoxSearchBy.getChildren().addAll(nameSearchLabel, searchChoiceBox);

        ChoiceBox statusChoiceBox = new ChoiceBox(FXCollections.observableArrayList("NEW", "PLAYING", "FINISHED"));
        TextField searchTextField = new TextField();
        searchChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String selected = searchChoiceBox.getSelectionModel().getSelectedItem();

               if (selected.equalsIgnoreCase("Status")){
                    if(!vBoxSearchBy.getChildren().contains(statusChoiceBox)) {
                        vBoxSearchBy.getChildren().add(statusChoiceBox);
                    }else if (vBoxSearchBy.getChildren().contains(searchTextField)){
                        vBoxSearchBy.getChildren().remove(searchTextField);
                    }
               }else {
                    if(!vBoxSearchBy.getChildren().contains(searchTextField)) {
                        vBoxSearchBy.getChildren().add(searchTextField);
                    } else if(vBoxSearchBy.getChildren().contains(statusChoiceBox)){
                        vBoxSearchBy.getChildren().remove(statusChoiceBox);
                    }
               }

            }
        });

//        Label statusSearchLabel = new Label("Search by status:");
//        ChoiceBox choiceBoxSearch = new ChoiceBox(FXCollections.observableArrayList("New", "PLaying", "Finished"));
//        VBox vBoxSearchByStatus = new VBox();
//        vBoxSearchByStatus.getChildren().addAll(statusSearchLabel, choiceBoxSearch);
//
//        Label platformSearchLabel = new Label("Search by platform:");
//        TextField textFieldSearchByPlatform = new TextField();
//        VBox vBoxSearchByPlatform = new VBox();
//        vBoxSearchByPlatform.getChildren().addAll(platformSearchLabel, textFieldSearchByPlatform);
//
//        Label publisherSearchLabel = new Label("Search by publisher:");
//        TextField textFieldSearchByPublisher = new TextField();
//        VBox vBoxSearchByPublisher = new VBox();
//        vBoxSearchByPublisher.getChildren().addAll(publisherSearchLabel, textFieldSearchByPublisher);
//
//        Label studioSearchLabel = new Label("Search by studio:");
//        TextField textFieldSearchByStudio = new TextField();
//        VBox vBoxSearchByStudio = new VBox();
//        vBoxSearchByStudio.getChildren().addAll(studioSearchLabel, textFieldSearchByStudio);
//
//        Label tagSearchLabel = new Label("Search by tag:");
//        TextField textFieldSearchByTag = new TextField();
//        VBox vBoxSearchByTag = new VBox();
//        vBoxSearchByTag.getChildren().addAll(tagSearchLabel, textFieldSearchByTag);

        Button searchButton = new Button("Search");


//Elements to show the list of games

        Text text = new Text();
        text.setWrappingWidth(500);


        ListView<Game> gameListView = new ListView<>();
        ObservableList<Game> games = FXCollections.observableList(gameDao.getAllGames());
        gameListView.setItems(games);
        VBox vBoxList = new VBox();
        vBoxList.getChildren().add(gameListView);
        vBoxList.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxList.setFillWidth(false);
        HBox gameInfoHBox = new HBox();
        gameInfoHBox.setAlignment(Pos.CENTER);
        gameInfoHBox.setFillHeight(false);

        gameListView.setOnMouseClicked(event -> {

            text.setText(gameListView.getSelectionModel().getSelectedItem().longToString());


        });

//        vBoxList.getChildren().add(text);
        gameInfoHBox.getChildren().add(text);


        VBox vBoxAddGame = new VBox();
        vBoxAddGame.getChildren().addAll(vBoxName, vBoxStatus, vBoxPlatform, vBoxPublisher, vBoxStudio, vBoxTag, vBoxButton);
        vBoxAddGame.setFillWidth(false);
        vBoxAddGame.setSpacing(5);
        vBoxAddGame.setAlignment(Pos.CENTER_LEFT);

        VBox vBoxSearchGame = new VBox();
        vBoxSearchGame.getChildren().addAll(
                vBoxSearchBy, searchButton);
        vBoxSearchGame.setFillWidth(false);
        vBoxSearchGame.setSpacing(5);
        vBoxSearchGame.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBoxAddGame, vBoxSearchGame, vBoxList);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setSpacing(20);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(title, hBox, gameInfoHBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameTextField.getText() != null && choiceBox.getValue() != null &&
                        platformTextField.getText() != null && publisherTextField.getText() != null && studioTextField.getText() != null
                        && tagTextField.getText() != null){
                    Game game = new Game();
                    game.setName(nameTextField.getText());
                    game.setStatus(Status.valueOf(choiceBox.getSelectionModel().getSelectedItem().toString()));
                    gameService.addPlatformToGame(game, platformTextField.getText());
                    gameService.addPublisherToGame(game, publisherTextField.getText());
                    gameService.addStudioToGame(game, studioTextField.getText());
                    gameService.addTagToGame(game, tagTextField.getText());
                    gameService.saveGame(game);

                }else {
                    System.out.println("ERROR");
                }
            gameListView.refresh();
            }
        });

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (statusChoiceBox.getSelectionModel().getSelectedItem().toString()){
                    case "Name":
                        gameListView.getItems().clear();
                        List<Game> gameList = new ArrayList<>();
                        gameList.add( gameDao.getByName(searchTextField.getText()));
                        ObservableList<Game> gamesByName = FXCollections.observableList(gameList);
//                     gameListView.setItems( gameList);
                    case "Status":
                        gameListView.getItems().clear();
                        ObservableList<Game> gamesByStatus = FXCollections.observableList(
                                gameDao.getByStatus(Status.valueOf(statusChoiceBox.getSelectionModel().getSelectedItem().toString())));
                        gameListView.setItems(gamesByStatus);
                        gameListView.refresh();
                    case "Platform":
                        gameListView.getItems().clear();
//                        ObservableList<Game> gameByPlatform = FXCollections.observableList(
//                                gameDao.getB
//                        )
                }
            }
        });


        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
