package io.zipcoder.actorsearch.Controllers;

import io.zipcoder.actorsearch.Entity.Actor;
import io.zipcoder.actorsearch.Entity.ActorDAO;
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

    /**
     * GET database information
     * @param name
     * @return
     */
    @RequestMapping(name = "/actor", method = RequestMethod.GET)
    public Iterable<Actor> getMoviesByActor(String name) {

        return actorDAO.findAll();
    }

    @RequestMapping(name = "/actor", method = RequestMethod.POST)
    public Actor searchMoviesByActor(@RequestParam String name) {
        MovieParse mp = new MovieParse();

        Actor actor = null;
        try {
            mp.makeActorRequest(name);
            actor =  mp.parseResponseDataIntoObjects();

            actorDAO.save(actor);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return  actor;

    }

}
