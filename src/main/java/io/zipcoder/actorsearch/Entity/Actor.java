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

    private String actor_photos;
    private String birthplace;
    private String bio;
    private String dob;

    /**
     * Default constructor
     */
    public Actor(){

    }

    /**
     * Actor constructor with data
     * @param name
     * @param actor_photos
     * @param movies
     * @param birthplace
     * @param bio
     * @param dob
     */
    public Actor(String name, String actor_photos, ArrayList<Movie> movies, String birthplace, String bio, String dob) {
        this.name = name;
        this.actor_photos = actor_photos;
        this.movies = movies;
        this.birthplace = birthplace;
        this.bio = bio;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getActor_photos() {
        return actor_photos;
    }

    public void setActor_photos(String actor_photos) {
        this.actor_photos = actor_photos;
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
