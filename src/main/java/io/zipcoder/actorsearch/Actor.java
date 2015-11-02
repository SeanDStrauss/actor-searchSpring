package io.zipcoder.actorsearch;

/**
 * Created by BatComputer on 11/2/15.
 */
public class Actor {
    private String name;
    private int age;
    private String actorPhotos;
    private String[] titleArray;

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

    public String[] getTitleArray() {
        return titleArray;
    }

    public void setTitleArray(String[] titleArray) {
        this.titleArray = titleArray;
    }
}
