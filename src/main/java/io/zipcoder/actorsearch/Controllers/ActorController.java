package io.zipcoder.actorsearch.Controllers;

import io.zipcoder.actorsearch.Entity.Actor;
import io.zipcoder.actorsearch.Entity.ActorDAO;
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




@Autowired
    ActorDAO actorDAO;

    @RequestMapping(name = "/actor", method = RequestMethod.GET)
    public Actor getMoviesByActor(String name) {

        return new Actor();
    }

    @RequestMapping(name = "/actor", method = RequestMethod.POST)
    public Actor searchMoviesByActor(@RequestParam String name) {
        MovieParse mp = new MovieParse();

        Actor actor = null;
        try {
            mp.makeActorRequest(name);
            actor =  mp.searchByActor(name);
            actorDAO.save(actor);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //actor.setName(name);

       // System.out.println(mp.searchByActor(name));

        return  actor;

    }

}
