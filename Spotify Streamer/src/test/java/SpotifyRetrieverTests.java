
import resources.SpotifyRetriever;
import org.junit.Assert;
import org.junit.Test;

public class SpotifyRetrieverTests {

    @Test
    public void testSpotifySearchTracks() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.searchTracks("Despacito"));
    }

    @Test
    public void testSpotifyGetAccessToken() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getAccessToken());
    }

    @Test
    public void testSpotifyGetTrackName() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertEquals("Despacito - Remix", retriever.getTrackName("Despacito"));
    }

    @Test
    public void testSpotifyGetTrackArtistsNames() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertEquals("Kokoroko  ", retriever.getTrackArtistsNames("Abusey Junction"));
    }

    @Test
    public void testSpotifyGetTrackId() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertEquals("6rPO02ozF3bM7NnOV4h6s2", retriever.getTrackId("Despacito"));
    }

    @Test
    public void testSpotifyGetTrackDuration() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertEquals(228826, retriever.getTrackDuration("Despacito"));
    }

    @Test
    public void testSpotifyGetAvailableGenreSeeds() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getAvailableGenreSeeds());
    }

    @Test
    public void testSpotifyGetTrackArtistObject() {
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getTrackArtistObject("1uNFoZAHBGtllmzznpCI3s"));
    }

    @Test
    //The track ID for this test is for "Despacito." This function returns just Track names.
    public void testSpotifyGetTrackRecommendationsBasedOnTrackID(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getTrackRecommendationsBasedOnTrackID("6rPO02ozF3bM7NnOV4h6s2"));
    }

    @Test
    //The track ID for this test is for "A Tribe Called Quest: Can I Kick It." This function returns just Track artists.
    public void testSpotifyGetArtistRecommendationsBasedOnTrackID(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getArtistRecommendationsBasedOnTrackID("3Ti0GdlrotgwsAVBBugv0I"));
    }

    @Test
    //The track ID for this test is for "blink-182: All The Small Things." This function returns Track artists and their Track names.
    public void testSpotifyGetArtistAndTheirTrackRecommendationsBasedOnTrackID(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getArtistAndTheirTrackRecommendationsBasedOnTrackID("7yCPwWs66K8Ba5lFuU2bcx"));
    }

    @Test
    //returns current hip-hop songs
    public void testSpotifyGetHipHopArtistAndTheirTrackRecommendations(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getHipHopTrackRecommendations());
    }

    @Test
    //returns current alternate rock songs
    public void testSpotifyGetAltRockArtistAndTheirTrackRecommendations(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getAltRockTrackRecommendations());
    }

    @Test
    //returns track Id based on the searched track
    public void testSpotifyGetTrackIdBasedOnSearch(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertEquals("6rPO02ozF3bM7NnOV4h6s2", retriever.getTrackIdBasedOnSearch("Despacito"));
    }

    @Test
    //returns artists and their tracks based on a searched track
    public void testSpotifyGetArtistAndTheirTrackRecommendationsBasedOnSearchedTrackID(){
        SpotifyRetriever retriever = new SpotifyRetriever();
        Assert.assertNotNull(retriever.getArtistAndTheirTrackRecommendationsBasedOnSearchedTrackID("Powerglide"));
    }


}

