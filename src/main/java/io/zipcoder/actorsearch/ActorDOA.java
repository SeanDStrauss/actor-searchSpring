package io.zipcoder.actorsearch;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by BatComputer on 11/2/15.
 */
public interface ActorDOA extends CrudRepository<Actor, Integer> {
    Actor findByActor(String name);
    Actor findById(Integer id);
}
