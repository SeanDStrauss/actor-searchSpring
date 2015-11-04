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


    private String name;


    private String age;




    private String actorPhotos;
    @Transient
    private ArrayList<Movie> movies;




    public Actor(){

    }
    public Actor(String name, String actorPhotos, ArrayList<Movie> movies) {
        this.name = name;
        this.actorPhotos = actorPhotos;
        this.movies = movies;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getActorPhotos() {
        return actorPhotos;
    }

    public void setActorPhotos(String actorPhotos) {
        this.actorPhotos = actorPhotos;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
