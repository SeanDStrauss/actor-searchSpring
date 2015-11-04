package io.zipcoder.actorsearch.Entity;

import io.zipcoder.actorsearch.Movie;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by BatComputer on 11/2/15.
 */
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Transient
    private ArrayList<Movie> movies;

    private String name;
    private String actorPhotos;
    private String birthplace;
    private String bio;
    private String dob;


    public Actor(){

    }
    public Actor(String name, String actorPhotos, ArrayList<Movie> movies, String birthplace, String bio, String dob) {
        this.name = name;
        this.actorPhotos = actorPhotos;
        this.movies = movies;
        this.birthplace = birthplace;
        this.bio = bio;
        this.dob = dob;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
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

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
