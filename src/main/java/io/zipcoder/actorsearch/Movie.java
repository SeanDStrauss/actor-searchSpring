package io.zipcoder.actorsearch;

/**
 * Created by kmurphy on 11/2/15.
 */
public class Movie {
    private String title;
    private String imdbID;
    private String releaseYear;

    public Movie(String title, String imdbID, String releaseYear) {
        this.title = title;
        this.imdbID = imdbID;
        this.releaseYear = releaseYear;
    }

    public Movie(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
