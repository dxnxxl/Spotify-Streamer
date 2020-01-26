package bsu.edu.cs222;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchArtistsRequest;

import java.io.IOException;

public class SearchArtists {
    private String clientId = "128260561ca44170878c8c9bd7ff45db";
    private String clientSecret = "b5043f9d014d4b9e92443ce7ad5fea02";
    private SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();
    private ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
    private Artist[] artistsArray;

    public SearchArtists(String title) {
        try {
            setAccessToken();
            SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(title).market(CountryCode.US).limit(30).offset(0).build();
            artistsArray = searchArtistsRequest.execute().getItems();
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

    public String[] getArtistNames(){
        String[] names = new String[artistsArray.length];
        for (int x =0; x<artistsArray.length; x++) {
           names[x] =  artistsArray[x].getName();
        }
        return names;
    }

    public String[] getArtistPopularity(){
        String[] names = new String[artistsArray.length];
        for (int x =0; x<artistsArray.length; x++) {
            names[x] =  artistsArray[x].getPopularity().toString();
        }
        return names;
    }

    public String[] getArtistURL(){
        String[] names = new String[artistsArray.length];
        for (int x =0; x<artistsArray.length; x++) {
            names[x] =  artistsArray[x].getExternalUrls().get("spotify");
        }
        return names;
    }

    public String[] getArtistGenres(){
        String[] names = new String[artistsArray.length];
        String[] genres;
        StringBuilder allGenres = new StringBuilder();
        for (int x =0; x<artistsArray.length; x++) {
            genres =  artistsArray[x].getGenres();
            for (String artist : genres) {
                allGenres.append(artist).append(", ");
            }
            if(genres.length>1) {
                allGenres.deleteCharAt(allGenres.lastIndexOf(","));
            }
            names[x] = allGenres.toString();
            allGenres = new StringBuilder();
        }
        return names;
    }

    public Song[] getInfo() {
        Song[] info = new Song[artistsArray.length];
        String[] names = getArtistNames();
        String[] albums = getArtistPopularity();
        String[] artists = getArtistGenres();
        String[] id = getArtistURL();

        for (int x=0; x<artistsArray.length; x++){
            info[x]= new Song(names[x],albums[x],artists[x], id[x]);
        }
        return info;

    }
}
