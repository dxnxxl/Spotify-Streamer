import bsu.edu.cs222.SearchAlbum;
import org.junit.Assert;
import org.junit.Test;

public class SearchAlbumTests {

    @Test
    public void testSearchAlbums() {
        SearchAlbum retriever = new SearchAlbum("Technologic");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getAlbumNames()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Techno'logic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic\n" +
                "Technologic Age\n" +
                "Technologic EP\n" +
                "Technologic EP\n", titles.toString());
    }

    @Test
    public void testSearchAlbumTypes() {
        SearchAlbum retriever = new SearchAlbum("Technologic");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTypes()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "album\n" +
                "album\n" +
                "single\n" +
                "album\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "album\n" +
                "single\n" +
                "single\n" +
                "single\n" +
                "album\n" +
                "single\n" +
                "single\n", titles.toString());
    }

    @Test
    public void testSearchAlbumArtists() {
        SearchAlbum retriever = new SearchAlbum("Technologic");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getAlbumArtists()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("Daft Punk \n" +
                "Stereotype \n" +
                "Dino Maggiorana \n" +
                "Jose Guerrero \n" +
                "DJ Youngy \n" +
                "Dave Droid \n" +
                "Angel Love \n" +
                "OHBB \n" +
                "Twisted Loops \n" +
                "KITECUT \n" +
                "CJ XL \n" +
                "Macgaren \n" +
                "Jean Pierre Saussac \n" +
                "Toi Doi \n" +
                "Various Artists \n" +
                "Horatio, Trippy Soul \n" +
                "Cosmonet, Krunch, Doktor Froid \n" +
                "S.D.A \n" +
                "CJ XL \n" +
                "Jhon Denas \n" +
                "DJ Pavel Slim \n" +
                "Candy Corn \n" +
                "Franx \n" +
                "Paolo Lombardi \n" +
                "Various Artists \n" +
                "M.N.S \n" +
                "Fatman & Marini \n" +
                "Phunk Investigation \n" +
                "Bass Station \n" +
                "Max Noce, Pour Le Plaisir \n", titles.toString());
    }

    @Test
    public void testSearchSongsURL() {
        SearchAlbum retriever = new SearchAlbum("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getAlbumURL()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("https://open.spotify.com/album/3Gq2Dme9nesdgoqNNlcN8O\n" +
                "https://open.spotify.com/album/0B75OuY7kuQXfz7qF5r2l3\n" +
                "https://open.spotify.com/album/4uRarQtP1NTEVKBtKu3Irc\n" +
                "https://open.spotify.com/album/5VD9VTyg5AOWZWvY2CtuDM\n" +
                "https://open.spotify.com/album/7FfnwGI2o6zyAkChjajNbS\n" +
                "https://open.spotify.com/album/13z7mxzBpAvK1Cd7wOz8Mc\n" +
                "https://open.spotify.com/album/2etUcZsqZeD6TXPVPkQFgi\n" +
                "https://open.spotify.com/album/122giwKyFajejrXs0Mu4qg\n" +
                "https://open.spotify.com/album/4EKdVxoiiZL5lTspYIEqJU\n" +
                "https://open.spotify.com/album/3E2aRACxtKnRsVB3Dh83hh\n" +
                "https://open.spotify.com/album/7yXJHuBXqHuNXKvHwWBirS\n" +
                "https://open.spotify.com/album/7wirw63OS0VArn6ySkRUoc\n" +
                "https://open.spotify.com/album/5IGYsSf19WU6ndBu8QnIUQ\n" +
                "https://open.spotify.com/album/53UcVhCiIiTF28EHzns2yk\n" +
                "https://open.spotify.com/album/4ERyGbuLKlxj86h7HIQChz\n" +
                "https://open.spotify.com/album/078WhFRHADyd2ZjXx0Vv5N\n" +
                "https://open.spotify.com/album/2FBogNXH1FFIGeAmtr16Bw\n" +
                "https://open.spotify.com/album/7bX9PK9BzyHuGAe8kEkm8o\n" +
                "https://open.spotify.com/album/6le1qCjBYFCZy4vsn9skNY\n" +
                "https://open.spotify.com/album/7qyQawobslyJpFiCynC2nV\n" +
                "https://open.spotify.com/album/7Kwqer08xFuUFTiNvH6kgL\n" +
                "https://open.spotify.com/album/5O4qTeLHYerckONhEq7PMH\n" +
                "https://open.spotify.com/album/6ovgtqjSgGbZQO4Am8VSKO\n" +
                "https://open.spotify.com/album/2qkJ5HlyUp3tjSTaqP2ev2\n" +
                "https://open.spotify.com/album/7BNJJcNujyKegGuuhOqFDi\n" +
                "https://open.spotify.com/album/2EG9S2eTIbjFTFEAoosniK\n" +
                "https://open.spotify.com/album/5F7uHUJygBSWf1SjIWP58g\n" +
                "https://open.spotify.com/album/7mQcblmDLhJCmSJLCRW96p\n" +
                "https://open.spotify.com/album/1Pt8HB8WKl2eVAgE0MTMeB\n" +
                "https://open.spotify.com/album/300pQtlBf19RMzkw0Zr6XT\n", titles.toString());
    }
}
