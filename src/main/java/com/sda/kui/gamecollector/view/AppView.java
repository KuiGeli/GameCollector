package com.sda.kui.gamecollector.view;

import com.sda.kui.gamecollector.dao.GameDao;
import com.sda.kui.gamecollector.model.Game;
import com.sda.kui.gamecollector.model.Status;
import com.sda.kui.gamecollector.services.GameService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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

                if (vBoxSearchBy.getChildren().contains(statusChoiceBox)) {
                    vBoxSearchBy.getChildren().remove(statusChoiceBox);
                }
                if (vBoxSearchBy.getChildren().contains(searchTextField)) {
                    vBoxSearchBy.getChildren().remove(searchTextField);
                }

                if (selected.equalsIgnoreCase("Status")) {
                    vBoxSearchBy.getChildren().add(statusChoiceBox);
                }
                if (!selected.equalsIgnoreCase("Status") && selected != null) {
                    vBoxSearchBy.getChildren().add(searchTextField);
                }


            }
        });

        Button searchButton = new Button("Search");


//        Controls to manipulate an existing game


        Button deleteGameButton = new Button("Delete");

        Label addToGameLabel = new Label("Add: ");
        ChoiceBox<String> addToGameChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(
                "Platform", "Publisher", "Studio", "Tag"
        ));
        TextField addTGameTextField = new TextField();
        Button addToGameButton = new Button("Add");
        VBox addToGameVBox = new VBox();
        addToGameVBox.getChildren().addAll(addToGameLabel, addToGameChoiceBox, addTGameTextField, addToGameButton);
        addToGameVBox.setSpacing(5);

        Label changeGameStatusLabel = new Label("Change status:");
        ChoiceBox<String> changeGameStatusChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(
                "NEW", "PLAYING", "FINISHED"
        ));
        Button changeGameStatusButton = new Button("Change status");

        VBox statusChangeVBox = new VBox();
        statusChangeVBox.getChildren().addAll(changeGameStatusLabel, changeGameStatusChoiceBox, changeGameStatusButton);
        statusChangeVBox.setSpacing(5);


        HBox gameControlHBox = new HBox();
        gameControlHBox.getChildren().addAll(addToGameVBox, statusChangeVBox, deleteGameButton);
        gameControlHBox.visibleProperty().setValue(false);
        gameControlHBox.setSpacing(50);



//Elements to show the list of games

        Text text = new Text();
        text.setWrappingWidth(500);

        Button refreshList = new Button("Refresh List");

        ListView<Game> gameListView = new ListView<>();
        gameListView.setItems(FXCollections.observableList(gameDao.getAllGames()));
        VBox vBoxList = new VBox();
        vBoxList.getChildren().addAll(refreshList, gameListView);
        vBoxList.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxList.setFillWidth(false);
        HBox gameInfoHBox = new HBox();
        gameInfoHBox.setAlignment(Pos.CENTER);
        gameInfoHBox.setFillHeight(false);

        gameListView.setOnMouseClicked(event -> {

            text.setText(gameListView.getSelectionModel().getSelectedItem().longToString());
            gameControlHBox.visibleProperty().setValue(true);
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
        vBox.getChildren().addAll(title, hBox, gameInfoHBox, gameControlHBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);

        //Refresh List Button method
        refreshList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                gameListView.setItems(FXCollections.observableList(gameDao.getAllGames()));
            }
        });

// Add new game Button method
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nameTextField.getText() != null && choiceBox.getValue() != null &&
                        platformTextField.getText() != null && publisherTextField.getText() != null && studioTextField.getText() != null
                        && tagTextField.getText() != null) {
                    Game game = new Game();
                    game.setName(nameTextField.getText());
                    game.setStatus(Status.valueOf(choiceBox.getSelectionModel().getSelectedItem().toString()));


                    gameService.addPlatformToGame(game, platformTextField.getText());
                    gameService.addPublisherToGame(game, publisherTextField.getText());
                    gameService.addStudioToGame(game, studioTextField.getText());
                    gameService.addTagToGame(game, tagTextField.getText());
                    gameService.saveGame(game);

                }
                gameListView.setItems(FXCollections.observableList(gameDao.getAllGames()));
            }
        });


// Search Button Method
        searchButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switch (searchChoiceBox.getSelectionModel().getSelectedItem().toString()) {
                    case "Name":
                        List<Game> gameList = new ArrayList<>();
                        gameList.add(gameDao.getByName(searchTextField.getText()));
                        ObservableList<Game> gamesByName = FXCollections.observableList(gameList);
                        gameListView.setItems(gamesByName);
                        gameListView.refresh();
                        break;
                    case "Status":
                        gameListView.getItems().clear();
                        ObservableList<Game> gamesByStatus = FXCollections.observableList(
                                gameDao.getByStatus(Status.valueOf(statusChoiceBox.getSelectionModel().getSelectedItem().toString())));
                        gameListView.setItems(gamesByStatus);
                        gameListView.refresh();
                        break;
                    case "Platform":
                        gameListView.getItems().clear();
                        ObservableList<Game> gameByPlatform = FXCollections.observableList(gameDao.getByPlatform(searchTextField.getText()));
                        gameListView.setItems(gameByPlatform);
                        gameListView.refresh();
                        break;
                    case "Publisher":
                        gameListView.getItems().clear();
                        ObservableList<Game> gameByPublisher = FXCollections.observableList(gameDao.getByPublisher(searchTextField.getText()));
                        gameListView.setItems(gameByPublisher);
                        gameListView.refresh();
                        break;
                    case "Studio":
                        gameListView.getItems().clear();
                        ObservableList<Game> gameByStudio = FXCollections.observableList(gameDao.getByStudio(searchTextField.getText()));
                        gameListView.setItems(gameByStudio);
                        gameListView.refresh();
                        break;
                    case "Tag":
                        gameListView.getItems().clear();
                        ObservableList gameByTag = FXCollections.observableList(gameDao.getByTag(searchTextField.getText()));
                        gameListView.setItems(gameByTag);
                        gameListView.refresh();
                        break;
                }
            }
        });



        //Delete button method

        deleteGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String game = gameListView.getSelectionModel().getSelectedItem().getName();
                gameDao.deleteByName(game);
                gameListView.setItems(FXCollections.observableList(gameDao.getAllGames()));

            }
        });

        //Change game status Button Method

        changeGameStatusButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Game game =  gameListView.getSelectionModel().getSelectedItem();
               game.setStatus(Status.valueOf(changeGameStatusChoiceBox.getSelectionModel().getSelectedItem()));
               gameDao.save(game);
               gameListView.refresh();

            }
        });

        //Add to game Button method

        addToGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switch (addToGameChoiceBox.getSelectionModel().getSelectedItem()){
                    case "Platform":
                        gameService.addPlatformToGame(
                                gameListView.getSelectionModel().getSelectedItem(),
                                addTGameTextField.getText()
                        );
                        break;
                    case "Publisher":
                        gameService.addPublisherToGame(
                                gameListView.getSelectionModel().getSelectedItem(),
                                addTGameTextField.getText());
                        break;
                    case "Studio":
                        gameService.addStudioToGame(
                                gameListView.getSelectionModel().getSelectedItem(),
                                addTGameTextField.getText());
                        break;
                    case "Tag":
                        gameService.addTagToGame(
                                gameListView.getSelectionModel().getSelectedItem(),
                                addTGameTextField.getText()
                        );
                        break;
                }
            }
        });



        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
