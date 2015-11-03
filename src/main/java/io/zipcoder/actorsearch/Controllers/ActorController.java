package io.zipcoder.actorsearch.Controllers;

import io.zipcoder.actorsearch.Entity.Actor;
import io.zipcoder.actorsearch.Entity.ActorDAO;
import io.zipcoder.actorsearch.Movie;
import io.zipcoder.actorsearch.MovieParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    public ArrayList<Movie> searchMoviesByActor(@RequestParam String name) {
        MovieParse mp = new MovieParse();

        Actor actor = new Actor();
        try {
            mp.makeActorRequest(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
        actor.setName(name);



        return  mp.searchByActor(name);

    }

}
