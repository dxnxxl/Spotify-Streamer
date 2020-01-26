import bsu.edu.cs222.SearchSongs;
import org.junit.Assert;
import org.junit.Test;

public class SearchSongsTests {

    @Test
    public void testSearchSongsTitles() {
        SearchSongs retriever = new SearchSongs("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackNames()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("Despacito - Remix\n" +
                "Despacito\n" +
                "Despacito Too\n" +
                "Despacito Too\n" +
                "Despacito Too\n" +
                "Despacito Too\n" +
                "Despacito x Shape Of You\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito - Major Lazer & MOSKA Remix\n" +
                "Quiéreme Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito - Versión Salsa\n" +
                "Despacito\n" +
                "Despacito/I'm The One - Mashup\n" +
                "Despacito, Muy Despacito\n" +
                "Despacito 2\n" +
                "Despacito\n" +
                "Despacito (Metal Version)\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito - Bachata Version\n" +
                "Despacito 緩緩 - Mandarin Version\n", titles.toString());
    }

    @Test
    public void testSearchSongsAlbums() {
        SearchSongs retriever = new SearchSongs("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackAlbums()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("Despacito Feat. Justin Bieber (Remix)\n" +
                "Shut Up Lets Dance\n" +
                "DiCaprio 2\n" +
                "DiCaprio 2\n" +
                "DiCaprio 2\n" +
                "DiCaprio 2\n" +
                "PTX Presents: Top Pop, Vol. I\n" +
                "Despacito\n" +
                "Despacito\n" +
                "Despacito Season\n" +
                "Kawaii\n" +
                "Let There Be Cello\n" +
                "Despacito (Major Lazer & MOSKA Remix)\n" +
                "Un Besito Más\n" +
                "VSQ Performs the Hits of 2017 Vol. 2\n" +
                "Despacito\n" +
                "Cover Sessions, Vol. 4\n" +
                "Despacito\n" +
                "Despacito (Versión Salsa)\n" +
                "Despacito\n" +
                "Despacito/I'm The One (Mashup)\n" +
                "Los Reyes de La Música Ranchera Volume 1\n" +
                "Despacito 2\n" +
                "Brooklyn Sessions VII\n" +
                "Leo Metal Covers, Vol. 15\n" +
                "Rose\n" +
                "Beautiful Dreams\n" +
                "Got You Covered, Vol. 2\n" +
                "Despacito (Bachata Version)\n" +
                "Despacito 緩緩 (Mandarin Version)\n", titles.toString());
    }

    @Test
    public void testSearchSongsArtists() {
        SearchSongs retriever = new SearchSongs("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackArtists()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("Luis Fonsi, Daddy Yankee, Justin Bieber \n" +
                "Luis Fonsi, Daddy Yankee \n" +
                "JID \n" +
                "JID \n" +
                "JID \n" +
                "JID \n" +
                "Pentatonix \n" +
                "Madilyn Bailey, Leroy Sanchez \n" +
                "Ramon Ayala, Erika Ender, Luis Rodríguez, 2CELLOS \n" +
                "Conor Maynard \n" +
                "Kawaii Box \n" +
                "2CELLOS \n" +
                "Luis Fonsi, Daddy Yankee, Major Lazer, MOSKA \n" +
                "Jesse & Joy \n" +
                "Vitamin String Quartet \n" +
                "Peter Bence \n" +
                "Boyce Avenue \n" +
                "Daniel Jang \n" +
                "Luis Fonsi, Víctor Manuelle, Victor M. Ruiz \n" +
                "Siggno \n" +
                "Alex Aiono \n" +
                "Pedro Infante \n" +
                "Kollavinilika \n" +
                "Brooklyn Duo \n" +
                "Leo \n" +
                "J.Fla \n" +
                "Tyler and Mark \n" +
                "Diego Teksuo \n" +
                "Grupo Extra \n" +
                "Luis Fonsi, JJ Lin \n", titles.toString());
    }

    @Test
    public void testSearchSongsURL() {
        SearchSongs retriever = new SearchSongs("Despacito");
        StringBuilder titles = new StringBuilder();
        for (String song:retriever.getTrackURL()) {
            titles.append(song).append("\n");
        }
        Assert.assertEquals("https://open.spotify.com/track/6rPO02ozF3bM7NnOV4h6s2\n" +
                "https://open.spotify.com/track/5AgTL2WmiCvoObA8fpncKs\n" +
                "https://open.spotify.com/track/4o9lniSBluLJwvNNsK1JyS\n" +
                "https://open.spotify.com/track/5oyon6yOfwtsOFezIzuTki\n" +
                "https://open.spotify.com/track/4dIPXdy3qgOkarh4Swi33Z\n" +
                "https://open.spotify.com/track/2oUI2kKbVOowQpg0flQbkr\n" +
                "https://open.spotify.com/track/5cj54CVe4pQZ9cUKgbsZrG\n" +
                "https://open.spotify.com/track/4vxA3aI7l73i0Hi819OQhH\n" +
                "https://open.spotify.com/track/3vqyauyYbp9MqUwrCEmWJ0\n" +
                "https://open.spotify.com/track/4s7OsY248WVd7BRVJGTU5i\n" +
                "https://open.spotify.com/track/428FuMhaSt3sgfFbAE0jQr\n" +
                "https://open.spotify.com/track/6OIFsi2ov9nSjRrnJWVZIM\n" +
                "https://open.spotify.com/track/2soXzaiEWhHzUCnSi94jTv\n" +
                "https://open.spotify.com/track/4oSmllN9KoFbU1qcn7KbCG\n" +
                "https://open.spotify.com/track/7tRWXbO5t4kvITSo0hEkF3\n" +
                "https://open.spotify.com/track/4V7Sfp9US8HXNMOwGlYqbS\n" +
                "https://open.spotify.com/track/0kjXWQm5HJwjAykPJsagbN\n" +
                "https://open.spotify.com/track/0AJdhH6yPNx7AkjD3uPYwD\n" +
                "https://open.spotify.com/track/5aPZ8WDKgtij3zbknGFnhC\n" +
                "https://open.spotify.com/track/51A2oDCMMj3BS9uXHVzmPP\n" +
                "https://open.spotify.com/track/4heyLRfAnfVxMLnsqQyB6X\n" +
                "https://open.spotify.com/track/2tSY5ox082qGiuWtQ6Q0px\n" +
                "https://open.spotify.com/track/5DBC6GI5dCodKKTjn89ABT\n" +
                "https://open.spotify.com/track/5d7SHRXBEbqjSJ46LF2vOx\n" +
                "https://open.spotify.com/track/04pWdQkbzwZKzZEvIzkGhx\n" +
                "https://open.spotify.com/track/4Nm3EfmBL3p7oTsRMv9qRu\n" +
                "https://open.spotify.com/track/1qSkgoE1o3fY86lUTbLCDT\n" +
                "https://open.spotify.com/track/4PBh66PQKjoD5nuRMrKb0O\n" +
                "https://open.spotify.com/track/1488SioojRAQGLhNJQwdIt\n" +
                "https://open.spotify.com/track/0zmOzthR1eSlpN0IMwzXyV\n", titles.toString());
    }
}
