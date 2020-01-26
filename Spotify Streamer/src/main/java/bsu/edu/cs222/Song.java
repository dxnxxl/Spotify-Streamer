package bsu.edu.cs222;

import javafx.beans.property.SimpleStringProperty;

public class Song {
    private SimpleStringProperty Title;
    private SimpleStringProperty Album;
    private SimpleStringProperty Artist;
    private SimpleStringProperty Id;

    Song(String title, String album, String artist, String id){
        Artist = new SimpleStringProperty(artist);
        Album = new SimpleStringProperty(album);
        Title = new SimpleStringProperty(title);
        Id = new SimpleStringProperty(id);
    }

    public String getArtist(){
        return Artist.get();
    }

    public String getAlbum(){
        return Album.get();
    }

    public String getTitle(){
        return Title.get();
    }

    public String getId() { return Id.get(); }
}
