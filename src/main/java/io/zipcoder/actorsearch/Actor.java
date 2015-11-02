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

    private String actorPhotos;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getActorPhotos() {
        return actorPhotos;
    }

    public void setActorPhotos(String actorPhotos) {
        this.actorPhotos = actorPhotos;
    }




}
