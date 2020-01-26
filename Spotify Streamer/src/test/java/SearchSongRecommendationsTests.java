import bsu.edu.cs222.SearchSongRecommendation;
import org.junit.Assert;
import org.junit.Test;

public class SearchSongRecommendationsTests {

    @Test
    public void testSearchSongRecommendationTitles() {
        SearchSongRecommendation retriever = new SearchSongRecommendation("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackNames()) {
            titles.append(song).append("\n");
        }
        Assert.assertNotNull(titles.toString());
    }

    @Test
    public void testSearchSongRecommendationAlbums() {
        SearchSongRecommendation retriever = new SearchSongRecommendation("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackAlbums()) {
            titles.append(song).append("\n");
        }
        Assert.assertNotNull(titles.toString());
    }

    @Test
    public void testSearchSongRecommendationArtists() {
        SearchSongRecommendation retriever = new SearchSongRecommendation("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackArtists()) {
            titles.append(song).append("\n");
        }
        Assert.assertNotNull(titles.toString());
    }

    @Test
    public void testSearchSongRecommendationURL() {
        SearchSongRecommendation retriever = new SearchSongRecommendation("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackURL()) {
            titles.append(song).append("\n");
        }
        Assert.assertNotNull(titles.toString());
    }
}
