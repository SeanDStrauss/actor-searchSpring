package io.zipcoder.actorsearch;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * Created by BatComputer on 11/2/15.
 */


public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull

    private int age;

    @NotNull

    private String actorPhotos;
    private ArrayList<Movie> movies;

    public Actor(){

    }
    public Actor(String name, String actorPhotos, ArrayList<Movie> movies) {
        this.name = name;
        this.actorPhotos = actorPhotos;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getActorPhotos() {
        return actorPhotos;
    }

    public void setActorPhotos(String actorPhotos) {
        this.actorPhotos = actorPhotos;
    }


    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }





}
