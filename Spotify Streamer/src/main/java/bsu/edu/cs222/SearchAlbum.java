package bsu.edu.cs222;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchAlbumsRequest;

import java.io.IOException;

public class SearchAlbum {
    private String clientId = "128260561ca44170878c8c9bd7ff45db";
    private String clientSecret = "b5043f9d014d4b9e92443ce7ad5fea02";
    private SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();
    private ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
    private AlbumSimplified[] albumArray;

    public SearchAlbum(String title) {
        try {
            setAccessToken();
            SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(title).market(CountryCode.US).limit(30).offset(0).build();
            albumArray = searchAlbumsRequest.execute().getItems();
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setAccessToken() {
        try {
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println(e.getMessage());
        }
    }


    public String[] getAlbumNames(){
        String[] names = new String[albumArray.length];
        for (int x =0; x<albumArray.length; x++) {
           names[x] =  albumArray[x].getName();
        }
        return names;
    }

    public String[] getTypes(){
        String[] names = new String[albumArray.length];
        for (int x =0; x<albumArray.length; x++) {
            names[x] =  albumArray[x].getAlbumType().getType();
        }
        return names;
    }

    public String[] getAlbumURL(){
        String[] names = new String[albumArray.length];
        for (int x =0; x<albumArray.length; x++) {
            names[x] =  albumArray[x].getExternalUrls().get("spotify");
        }
        return names;
    }

    public String[] getAlbumArtists(){
        String[] names = new String[albumArray.length];
        ArtistSimplified[] artists;
        StringBuilder allAlbums = new StringBuilder();

        for (int x =0; x<albumArray.length; x++) {
            artists =  albumArray[x].getArtists();
            for (ArtistSimplified artist : artists) {
                allAlbums.append(artist.getName()).append(", ");
            }
            allAlbums.deleteCharAt(allAlbums.lastIndexOf(","));
            names[x] = allAlbums.toString();
            allAlbums = new StringBuilder();
        }
        return names;
    }

    public Song[] getInfo() {
        Song[] info = new Song[albumArray.length];
        String[] names = getAlbumNames();
        String[] types = getTypes();
        String[] artists = getAlbumArtists();
        String[] id = getAlbumURL();

        for (int x=0; x<albumArray.length; x++){
            info[x]= new Song(names[x],types[x],artists[x], id[x]);
        }
        return info;

    }
}
