package io.zipcoder.actorsearch.Controllers;

import io.zipcoder.actorsearch.Entity.Actor;
import io.zipcoder.actorsearch.Entity.ActorDAO;
import io.zipcoder.actorsearch.Movie;
import io.zipcoder.actorsearch.MovieDAO;
import io.zipcoder.actorsearch.MovieParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by BatComputer on 11/2/15.
 */
@RestController
public class ActorController {
    @Autowired
    ActorDAO actorDAO;

    @Autowired
    MovieDAO movieDAO;

    /**
     * GET database information
     * @param name
     * @return
     */
    @RequestMapping(name = "/actor", method = RequestMethod.GET)
    public Actor getMoviesByActor(String name) {
        MovieParse movieParse = null;
        Actor actor = null;
        actor = actorDAO.findOneByName(name);
            if (actor == null) {
                return searchMoviesByActor(name);
            } else {
                return actor;
            }

    }

    @RequestMapping(name = "/actor", method = RequestMethod.POST)
    public Actor searchMoviesByActor(@RequestParam String name) {
        MovieParse mp = new MovieParse();
        Actor actor = null;
        Movie movie = null;
        try {
            mp.makeActorRequest(name);
            actor =  mp.parseResponseDataIntoObjects();
            for(Movie key : actor.getMovies()) {
                movieDAO.save(key);
            }
            actorDAO.save(actor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  actor;

    }

}
