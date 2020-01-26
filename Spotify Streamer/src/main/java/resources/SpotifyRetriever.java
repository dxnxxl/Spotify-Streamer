package resources;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.model_objects.specification.Recommendations;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.artists.GetArtistRequest;
import com.wrapper.spotify.requests.data.browse.GetRecommendationsRequest;
import com.wrapper.spotify.requests.data.browse.miscellaneous.GetAvailableGenreSeedsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import java.io.IOException;
import java.util.Arrays;

public class SpotifyRetriever {
    private String clientId = "128260561ca44170878c8c9bd7ff45db";
    private String clientSecret = "b5043f9d014d4b9e92443ce7ad5fea02";
    private SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();
    private ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

    public String getAccessToken() {
        try {
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            return clientCredentials.getAccessToken();
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println(e.getMessage());
            return "";
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

    public Track searchTracks(String title) {
        try {
            setAccessToken();
            SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(title).market(CountryCode.US).limit(10).offset(0).build();
            Paging<Track> trackPaging = searchTracksRequest.execute();

            return trackPaging.getItems()[0];
        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }
    }

    public String getTrackName(String title) {
        setAccessToken();
        return searchTracks(title).getName();
    }

    public String getTrackIdBasedOnSearch(String title) {
        setAccessToken();
        return searchTracks(title).getId();
    }

    public String getTrackArtistsNames(String title) {
        setAccessToken();
        ArtistSimplified[] artists = searchTracks(title).getArtists();
        StringBuilder allArtists = new StringBuilder();
        for (ArtistSimplified artist : artists) {
            allArtists.append(artist.getName()).append("  ");
        }
        return allArtists.toString();
    }

    public Artist getTrackArtistObject(String title) {
        try {
            setAccessToken();
            GetArtistRequest getArtistRequest = spotifyApi.getArtist(title).build();
            return getArtistRequest.execute();
        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }
    }

    public String getTrackId(String title) {
        setAccessToken();
        return searchTracks(title).getId();
    }

    public int getTrackDuration(String title) {
        setAccessToken();
        return searchTracks(title).getDurationMs();
    }

    public String[] getAvailableGenreSeeds() {
        try {
            setAccessToken();
            GetAvailableGenreSeedsRequest getAvailableGenreSeedsRequest = spotifyApi.getAvailableGenreSeeds().build();
            final String[] strings = getAvailableGenreSeedsRequest.execute();
            System.out.println(Arrays.toString(strings));
            return strings;

        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }

    }
    public TrackSimplified[] getTrackRecommendationsBasedOnTrackID (String trackID){
        setAccessToken();
        try {
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_tracks(trackID).build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            TrackSimplified[] trackRecommendations = recommendations.getTracks();
            for (TrackSimplified trackRecommendation : trackRecommendations) {
                System.out.println(trackRecommendation.getName());
            }

            return trackRecommendations;

        } catch (IOException | SpotifyWebApiException e){
            return null;
        }

    }

    public TrackSimplified[] getArtistRecommendationsBasedOnTrackID (String trackID){
        setAccessToken();
        try {
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_tracks(trackID).build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            TrackSimplified[] trackRecommendations = recommendations.getTracks();
            for (TrackSimplified trackRecommendation : trackRecommendations) {
                System.out.println(trackRecommendation.getArtists()[0].getName());
            }

            return trackRecommendations;

        } catch (IOException | SpotifyWebApiException e){
            return null;
        }

    }

    public TrackSimplified[] getArtistAndTheirTrackRecommendationsBasedOnTrackID (String trackID){
        setAccessToken();
        try {
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_tracks(trackID).build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            TrackSimplified[] trackRecommendations = recommendations.getTracks();
            for (TrackSimplified trackRecommendation : trackRecommendations) {
                System.out.println(trackRecommendation.getArtists()[0].getName() + ": " + trackRecommendation.getName());
            }

            return trackRecommendations;

        } catch (IOException | SpotifyWebApiException e){
            return null;
        }

    }


    public TrackSimplified[] getHipHopTrackRecommendations () {
        setAccessToken();
        try {
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_genres("hip-hop").build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            TrackSimplified[] trackRecommendations = recommendations.getTracks();
            for (TrackSimplified trackRecommendation : trackRecommendations) {
                System.out.println(trackRecommendation.getArtists()[0].getName() + ": " + trackRecommendation.getName());
            }

            return trackRecommendations;

        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }
    }

    public TrackSimplified[] getAltRockTrackRecommendations () {
        setAccessToken();
        try {
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_genres("alt-rock").build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            TrackSimplified[] trackRecommendations = recommendations.getTracks();
            for (TrackSimplified trackRecommendation : trackRecommendations) {
                System.out.println(trackRecommendation.getArtists()[0].getName() + ": " + trackRecommendation.getName());
            }

            return trackRecommendations;

        } catch (IOException | SpotifyWebApiException e) {
            return null;
        }
    }

    public TrackSimplified[] getArtistAndTheirTrackRecommendationsBasedOnSearchedTrackID (String title){
        setAccessToken();
        try {
            GetRecommendationsRequest getRecommendationsRequest = spotifyApi.getRecommendations().seed_tracks(searchTracks(title).getId()).build();
            Recommendations recommendations = getRecommendationsRequest.execute();
            TrackSimplified[] trackRecommendations = recommendations.getTracks();
            for (TrackSimplified trackRecommendation : trackRecommendations) {
                System.out.println(trackRecommendation.getArtists()[0].getName() + ": " + trackRecommendation.getName());
            }
            return trackRecommendations;
        } catch (IOException | SpotifyWebApiException e){
            return null;
        }
    }

}
