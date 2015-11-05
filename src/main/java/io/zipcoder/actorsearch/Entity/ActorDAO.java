package io.zipcoder.actorsearch.Entity;

import org.springframework.data.repository.CrudRepository;

/**
 * ActorDAO interface for connecting with the database.
 */
public interface ActorDAO extends CrudRepository<Actor, Integer> {
    Actor findOneByName(String name);

}
