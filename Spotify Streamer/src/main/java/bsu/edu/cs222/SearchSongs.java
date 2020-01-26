package bsu.edu.cs222;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;

public class SearchSongs {
    private String clientId = "128260561ca44170878c8c9bd7ff45db";
    private String clientSecret = "b5043f9d014d4b9e92443ce7ad5fea02";
    private SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();
    private ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
    private Track[] tracksArray;

    public SearchSongs(String title) {
        try {
            setAccessToken();
            SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(title).market(CountryCode.US).limit(30).offset(0).build();
            tracksArray = searchTracksRequest.execute().getItems();
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


    public String[] getTrackNames(){
        String[] names = new String[tracksArray.length];
        for (int x =0; x<tracksArray.length; x++) {
           names[x] =  tracksArray[x].getName();
        }
        return names;
    }

    public String[] getTrackURL(){
        String[] names = new String[tracksArray.length];
        for (int x =0; x<tracksArray.length; x++) {
            names[x] =  tracksArray[x].getExternalUrls().get("spotify");
        }
        return names;
    }

    public String[] getTrackAlbums(){
        String[] names = new String[tracksArray.length];
        for (int x =0; x<tracksArray.length; x++) {
            names[x] =  tracksArray[x].getAlbum().getName();
        }
        return names;
    }

    public String[] getTrackArtists(){
        String[] names = new String[tracksArray.length];
        ArtistSimplified[] artists;
        StringBuilder allArtists = new StringBuilder();

        for (int x =0; x<tracksArray.length; x++) {
            artists =  tracksArray[x].getArtists();
            for (ArtistSimplified artist : artists) {
                allArtists.append(artist.getName()).append(", ");
            }
            allArtists.deleteCharAt(allArtists.lastIndexOf(","));
            names[x] = allArtists.toString();
            allArtists = new StringBuilder();
        }
        return names;
    }

    public Song[] getInfo() {
        Song[] info = new Song[tracksArray.length];
        String[] names = getTrackNames();
        String[] albums = getTrackAlbums();
        String[] artists = getTrackArtists();
        String[] id = getTrackURL();

        for (int x=0; x<tracksArray.length; x++){
            info[x]= new Song(names[x],albums[x],artists[x], id[x]);
        }
        return info;

    }
}
