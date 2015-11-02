package io.zipcoder.actorsearch;

/**
 * Created by kmurphy on 11/2/15.
 */
public class Movie {
    private String title;
    private String imdbID;
    private String image;
    private String metascore;
    private String plot;
    private String rated;


    public Movie(){
    }

    public Movie(String title, String imdbID, String image, String metascore, String plot, String rated) {
        this.title = title;
        this.imdbID = imdbID;
        this.image = image;
        this.metascore = metascore;
        this.plot = plot;
        this.rated = rated;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }
}
