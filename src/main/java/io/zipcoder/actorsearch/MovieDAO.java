package io.zipcoder.actorsearch;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by BatComputer on 11/4/15.
 */

/**
 * MovieDAO to interface with the database.
 */
public interface MovieDAO extends CrudRepository<Movie, Integer> {
}
