package io.zipcoder.actorsearch;

/**
 * Created by BatComputer on 11/2/15.
 */
public class Actor {
    private String name;
    private String actorPhotos;
    private Movie[] movies;

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
