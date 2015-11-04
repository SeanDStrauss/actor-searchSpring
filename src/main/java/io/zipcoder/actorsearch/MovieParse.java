package io.zipcoder.actorsearch;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import io.zipcoder.actorsearch.Entity.Actor;
import io.zipcoder.actorsearch.Entity.ActorDAO;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * Created by BatComputer on 11/2/15.
 */
public class MovieParse {

    private HttpResponse<JsonNode> response;
    @Autowired
    private ActorDAO actorDAO;
    @Autowired
    private MovieDAO movieDAO;


    public HttpResponse<JsonNode> makeActorRequest(String actName) {
        try {
            response = Unirest.get("http://api.myapifilms.com/imdb/idIMDB?token=dafd0817-1c8d-48a2-b0c6-9c9b4480e4ff")
                    .queryString("name", actName)
                    .queryString("spouses", 1)
                    .queryString("filmography", 1)
                    .queryString("limit", 1)
                    .asJson();

        } catch (Exception e) {
           // e.printStackTrace();
        }
        searchByActor(actName);
        return response;
    }


    public HttpResponse<JsonNode> makeMovieRequest(String imdbID) {
        try {
            response = Unirest.get("http://api.myapifilms.com/imdb/idIMDB?token=dafd0817-1c8d-48a2-b0c6-9c9b4480e4ff")
                    .queryString("idIMDB", imdbID)
                    .asJson();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return response;
    }

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public void setResponse(HttpResponse<JsonNode> response) {
        this.response = response;
    }

    public Actor searchByActor(String searchName) {

        JSONArray names = response.getBody().getObject().getJSONObject("data").getJSONArray("names");
        JSONArray movieData = response.getBody().getObject().getJSONObject("data").getJSONArray("names").getJSONObject(0).getJSONArray("filmographies").getJSONObject(0).getJSONArray("filmography");
        String photo = names.getJSONObject(0).getString("urlPhoto");
        String name = names.getJSONObject(0).getString("name");
        String birthplace = names.getJSONObject(0).getString("placeOfBirth");
        String bio = names.getJSONObject(0).getString("bio");
        String dob = names.getJSONObject(0).getString("dateOfBirth");

        ArrayList<Movie> movieArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) { //iterate thru all of the actor's movies and add to list

            String title = movieData.getJSONObject(i).getString("title");
            String imdbid = movieData.getJSONObject(i).getString("imdbid");
            MovieParse movieParser = new MovieParse();
            HttpResponse<JsonNode> movie = movieParser.makeMovieRequest(imdbid);
            try {
                JSONArray movieinfo = movieParser.getResponse().getBody().getObject().getJSONObject("data").getJSONArray("movies");
                String image = movieinfo.getJSONObject(0).getString("urlPoster");
                String metascore = movieinfo.getJSONObject(0).getString("metascore");
                String plot = movieinfo.getJSONObject(0).getString("plot");
                String rated = movieinfo.getJSONObject(0).getString("rated");

                Movie movieObj = new Movie(title, imdbid, image, metascore, plot, rated);
                movieArrayList.add(movieObj);

                movieDAO.save(movieObj);

            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        Actor actor = null;
        try {
            actor = new Actor(name, photo, movieArrayList, birthplace, bio, dob);

        } catch (Exception e) {

        }

        return actor;
    }

    public static void main(String[] args){
        MovieParse movieParse = new MovieParse();
        String actor = "Ezra Miller";
        movieParse.makeActorRequest(actor);
        Actor actorObject = movieParse.searchByActor(actor);
        System.out.println("\n" + actorObject.getName());
        System.out.println(actorObject.getActor_photos());
        System.out.println(actorObject.getMovies().get(1).getTitle());

    }
}
