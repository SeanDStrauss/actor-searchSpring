package io.zipcoder.actorsearch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kmurphy on 11/2/15.
 */
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String imdb_id;

    @NotNull
    private String image;
    @NotNull
    private String metascore;
    @NotNull
    private String plot;
    @NotNull
    private String rated;


    public Movie(){
    }

    public Movie(String title, String imdb_id, String image, String metascore, String plot, String rated) {
        this.title = title;
        this.imdb_id = imdb_id;
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

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
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
