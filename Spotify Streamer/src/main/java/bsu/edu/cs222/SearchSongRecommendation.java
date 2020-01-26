package bsu.edu.cs222;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.browse.GetRecommendationsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;
import java.util.Objects;

public class SearchSongRecommendation {
    private String clientId = "128260561ca44170878c8c9bd7ff45db";
    private String clientSecret = "b5043f9d014d4b9e92443ce7ad5fea02";
    private SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();
    private ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
    private TrackSimplified[] recommendationArray;

    public SearchSongRecommendation(String title) {
        try {
            setAccessToken();
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_tracks(Objects.requireNonNull(searchTracks(title)).getId()).limit(30).build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            recommendationArray = recommendations.getTracks();
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

    private Track searchTracks(String title) {
        try {
            setAccessToken();
            SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(title).market(CountryCode.US).limit(10).offset(0).build();
            Paging<Track> trackPaging = searchTracksRequest.execute();
            return trackPaging.getItems()[0];
        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }
    }

    private Track getTrack(String title) {
        try {
            setAccessToken();
            GetTrackRequest getTracksRequest = spotifyApi.getTrack(title).build();
            return getTracksRequest.execute();
        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }
    }

    public String[] getTrackNames(){
        String[] names = new String[recommendationArray.length];
        for (int x =0; x<recommendationArray.length; x++) {
            names[x] =  recommendationArray[x].getName();
        }
        return names;
    }

    public String[] getTrackAlbums(){
        String[] names = new String[recommendationArray.length];
        for (int x =0; x<recommendationArray.length; x++){
            names[x] =  Objects.requireNonNull(getTrack(recommendationArray[x].getId())).getAlbum().getName();
        }
        return names;
    }

    public String[] getTrackURL(){
        String[] names = new String[recommendationArray.length];
        for (int x =0; x<recommendationArray.length; x++) {
            names[x] =  recommendationArray[x].getExternalUrls().get("spotify");
        }
        return names;
    }

    public String[] getTrackArtists(){
        String[] names = new String[recommendationArray.length];
        ArtistSimplified[] artists;
        StringBuilder allArtists = new StringBuilder();

        for (int x =0; x<recommendationArray.length; x++) {
            artists =  recommendationArray[x].getArtists();
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
        Song[] info = new Song[recommendationArray.length];
        String[] names = getTrackNames();
        String[] albums = getTrackAlbums();
        String[] artists = getTrackArtists();
        String[] id = getTrackURL();

        for (int x=0; x<recommendationArray.length; x++){
            info[x]= new Song(names[x],albums[x],artists[x], id[x]);
        }
        return info;

    }
}
