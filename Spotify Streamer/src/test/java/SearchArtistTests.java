import bsu.edu.cs222.SearchArtists;
import org.junit.Assert;
import org.junit.Test;

public class SearchArtistTests {

    @Test
    public void testSearchArtistsNames() {
        SearchArtists retriever = new SearchArtists("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getArtistNames()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("DJ Despacito\n" +
                "Despacito\n", titles.toString());
    }

    @Test
    public void testSearchArtistsGenres() {
        SearchArtists retriever = new SearchArtists("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getArtistGenres()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("\n" +
                "\n", titles.toString());
    }

    @Test
    public void testSearchArtistsPopularity() {
        SearchArtists retriever = new SearchArtists("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getArtistPopularity()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("19\n" +
                "19\n", titles.toString());
    }

    @Test
    public void testSearchSongsURL() {
        SearchArtists retriever = new SearchArtists("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getArtistURL()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("https://open.spotify.com/artist/7FOMXROGuSwWSd6bLZNQSM\n" +
                "https://open.spotify.com/artist/6NLvop3p7bOnMRwoYDMknn\n", titles.toString());
    }
}
