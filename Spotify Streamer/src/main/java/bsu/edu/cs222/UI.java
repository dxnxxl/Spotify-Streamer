package bsu.edu.cs222;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.*;

@SuppressWarnings("unchecked")
public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMinWidth(1200);
        primaryStage.setMaxWidth(1200);
        primaryStage.setMinHeight(800);
        primaryStage.setMaxHeight(800);

        VBox parent = new VBox(20);
        parent.setStyle("-fx-background-color: rgb(50,75,50);");
        parent.setPadding(new Insets(20));
        parent.setAlignment(Pos.TOP_CENTER);

        Label appName = new Label("Music Stream");
        parent.getChildren().add(appName);
        appName.setMaxWidth(600);
        appName.setMinWidth(600);
        appName.setAlignment(Pos.TOP_CENTER);
        appName.setStyle("-fx-background-color: rgb(30,30,30)");
        appName.setFont(Font.font("Futura", 36));
        appName.setTextFill(Color.WHITE);

        final VBox infoDisplayV = new VBox(10);
        parent.getChildren().add(infoDisplayV);
        infoDisplayV.setMaxWidth(1400);
        infoDisplayV.setMinWidth(1100);
        infoDisplayV.setMaxHeight(600);
        infoDisplayV.setMinHeight(600);
        infoDisplayV.setAlignment(Pos.CENTER);
        infoDisplayV.setStyle("-fx-background-color:rgb(30,30,30)");

        final Label searchLabel = new Label("Enter Keyword: ");
        searchLabel.setTextFill(Color.WHITE);
        searchLabel.setFont(Font.font("Futura", 16));

        final HBox searchTerm = new HBox(10, searchLabel);
        infoDisplayV.getChildren().add(searchTerm);
        searchTerm.setAlignment(Pos.CENTER);

        ObservableList<String> searchOptions = FXCollections.observableArrayList("Song Name", "Artist Name", "Album Name", "Song Recommendations");
        final ComboBox<String> searchOptionsBox = new ComboBox<>(searchOptions);
        searchTerm.getChildren().add(searchOptionsBox);

        final TextField termField = new TextField();
        searchTerm.getChildren().add(termField);

        final Button searchButton = new Button("Search For Music");
        searchButton.setFont(Font.font("Futura", 16));
        searchButton.setTextFill(Color.WHITE);
        searchButton.setStyle("-fx-background-color:rgb(127,129,133)");
        searchTerm.getChildren().add(searchButton);



        VBox LayoutForinfoDisplayH = new VBox();
        infoDisplayV.getChildren().add(LayoutForinfoDisplayH);
        LayoutForinfoDisplayH.setMaxWidth(1400);
        LayoutForinfoDisplayH.setMinWidth(1100);
        LayoutForinfoDisplayH.setMaxHeight(475);
        LayoutForinfoDisplayH.setMinHeight(475);
        LayoutForinfoDisplayH.setStyle("-fx-background-color: rgb(70,70,70)");
        LayoutForinfoDisplayH.setAlignment(Pos.CENTER);


        HBox infoDisplayH = new HBox(2);
        LayoutForinfoDisplayH.getChildren().add(infoDisplayH);
        infoDisplayH.setMaxWidth(1100);
        infoDisplayH.setMinWidth(1100);
        infoDisplayH.setMaxHeight(450);
        infoDisplayH.setMinHeight(450);
        infoDisplayH.setStyle("-fx-background-color: rgb(70,70,70)");
        infoDisplayH.setAlignment(Pos.CENTER);

        List<Song> songList = new ArrayList<>();

        final TableView<Song> SongInfoDisplayTable = new TableView<>();
        SongInfoDisplayTable.setMinWidth(1100);
        infoDisplayH.getChildren().add(SongInfoDisplayTable);

        final ObservableList<Song> SongList = FXCollections.observableArrayList(songList);
        SongInfoDisplayTable.setItems(SongList);

        final TableColumn<Song, String> songTitleColumn = new TableColumn<>("Title");
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("Title"));
        songTitleColumn.setMinWidth(300);

        final TableColumn<Song, String> albumTitleColumn = new TableColumn<>("Album");
        albumTitleColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("Album"));
        albumTitleColumn.setMinWidth(300);

        final TableColumn<Song, String> artistColumn = new TableColumn<>("Artist");
        artistColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("Artist"));
        artistColumn.setMinWidth(500);

        TableColumn<Song, String> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("Id"));
        idColumn.setMaxWidth(0);

        SongInfoDisplayTable.setItems(SongList);
        SongInfoDisplayTable.getColumns().setAll(songTitleColumn, albumTitleColumn, artistColumn, idColumn);



        HBox playButtonLayout = new HBox(10);
        infoDisplayV.getChildren().add(playButtonLayout);
        playButtonLayout.setMinWidth(600);
        playButtonLayout.setAlignment(Pos.CENTER);

        Button playButton = new Button("Play");
        playButton.setFont(Font.font("Futura", 18));
        playButton.setTextFill(Color.WHITE);
        playButton.setStyle("-fx-background-color:rgb(100,100,100)");
        playButton.setMinWidth(100);
        playButtonLayout.getChildren().add(playButton);
        playButton.setAlignment(Pos.CENTER);

        final VBox webBox = new VBox();
        webBox.setMinHeight(800);
        webBox.setMaxHeight(800);
        webBox.setMinWidth(1200);
        webBox.setMaxWidth(1200);

        WebView songBrowser = new WebView();
        final WebEngine webEngine = songBrowser.getEngine();
        songBrowser.setMinHeight(800);
        songBrowser.setMinWidth(1200);
        webBox.getChildren().add(songBrowser);


        final Stage webStage = new Stage();
        webStage.setMinWidth(1200);
        webStage.setMaxWidth(1200);
        webStage.setMinHeight(800);
        webStage.setMaxHeight(800);
        webStage.setResizable(false);

        Scene scene1 = new Scene(webBox);
        webStage.setScene(scene1);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (searchOptionsBox.getValue()!=null&&searchOptionsBox.getValue().equals("Song Name")) {
                    SongInfoDisplayTable.setItems(songName(termField.getText()));
                    songTitleColumn.setText("Title");
                    albumTitleColumn.setText("Album");
                    artistColumn.setText("Artist");
                }
                if (searchOptionsBox.getValue()!=null&&searchOptionsBox.getValue().equals("Artist Name")) {
                    SongInfoDisplayTable.setItems(artistName(termField.getText()));
                    songTitleColumn.setText("Name");
                    albumTitleColumn.setText("Popularity (1-100)");
                    artistColumn.setText("Genres");
                }
                if (searchOptionsBox.getValue()!=null&&searchOptionsBox.getValue().equals("Album Name")) {
                    SongInfoDisplayTable.setItems(albumName(termField.getText()));
                    songTitleColumn.setText("Album");
                    albumTitleColumn.setText("Album Type");
                    artistColumn.setText("Artist");
                }
                if (searchOptionsBox.getValue()!=null&&searchOptionsBox.getValue().equals("Song Recommendations")) {
                    SongInfoDisplayTable.setItems(songRecommendtions(termField.getText()));
                    songTitleColumn.setText("Title");
                    albumTitleColumn.setText("Album");
                    artistColumn.setText("Artist");
                }
            }
        });




        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if( SongInfoDisplayTable.getSelectionModel().getSelectedItem()!=null){
                        Song data = SongInfoDisplayTable.getSelectionModel().getSelectedItem();
                        webEngine.load(data.getId());
                        webStage.setTitle(data.getTitle());
                        webStage.show();
                }
            }
        });

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    private ObservableList<Song> songName(String title){
        ObservableList<Song> songs = FXCollections.observableArrayList();
        Song[] songArray = new SearchSongs(title).getInfo();
        songs.addAll(Arrays.asList(songArray));
        return songs;
    }

    private ObservableList<Song> albumName(String title){
        ObservableList<Song> songs = FXCollections.observableArrayList();
        Song[] songArray = new SearchAlbum(title).getInfo();
        Collections.addAll(songs, songArray);
        return songs;
    }

    private ObservableList<Song> songRecommendtions(String title){
        ObservableList<Song> songs = FXCollections.observableArrayList();
        Song[] songArray = new SearchSongRecommendation(title).getInfo();
        Collections.addAll(songs, songArray);
        return songs;
    }

    private ObservableList<Song> artistName(String title){
        ObservableList<Song> songs = FXCollections.observableArrayList();
        Song[] songArray = new SearchArtists(title).getInfo();
        Collections.addAll(songs, songArray);
        return songs;
    }


}


