package io.zipcoder.actorsearch.Controllers;

import io.zipcoder.actorsearch.Actor;
//import io.zipcoder.actorsearch.ActorDOA;
import io.zipcoder.actorsearch.MovieParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BatComputer on 11/2/15.
 */
@RestController
public class ActorController {

    //@Autowired
    //private ActorDOA actorDOA;

    @RequestMapping(name = "/actor", method = RequestMethod.GET)
    public Actor getMoviesByActor(String name) {
        Actor actor = new Actor();
        return actor;
    }

    @RequestMapping(name = "/actor", method = RequestMethod.POST)
    public String searchMoviesByActor(@RequestParam String name) {
        MovieParse mp = new MovieParse();

        Actor actor = new Actor();
        try {
            mp.makeActorRequest(name);
            //actorDOA.save((Iterable<Actor>) mp.makeActorRequest(name));
        } catch (Exception e) {

        }
        actor.setName(name);
        return actor.getName();

    }

}
