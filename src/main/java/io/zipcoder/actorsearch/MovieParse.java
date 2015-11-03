package io.zipcoder.actorsearch;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by BatComputer on 11/2/15.
 */
public class MovieParse {

    private HttpResponse<JsonNode> response;


    public HttpResponse<JsonNode> makeActorRequest(String actName) {
        try {
            response = Unirest.get("http://api.myapifilms.com/imdb/idIMDB?token=dafd0817-1c8d-48a2-b0c6-9c9b4480e4ff")
                    .queryString("name", actName)
                    .queryString("spouses", 1)
                    .queryString("filmography", 1)
                    .queryString("limit", 1)
                    .asJson();


        } catch (Exception e) {

        }
        return response;
    }


    public HttpResponse<JsonNode> makeMovieRequest(String imdbID) {
        try {
            response = Unirest.get("http://api.myapifilms.com/imdb/idIMDB?token=dafd0817-1c8d-48a2-b0c6-9c9b4480e4ff")
                    .queryString("idIMDB", imdbID)
                    .asJson();
        } catch (Exception e) {

        }
        return response;
    }

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public void setResponse(HttpResponse<JsonNode> response) {
        this.response = response;
    }

    public Actor searchByActor(MovieParse mp, String searchName){
        MovieParse actorParser = mp;

        HttpResponse<JsonNode> actorResponse = actorParser.makeActorRequest(searchName);

        JSONObject jsonObject = actorParser.getResponse().getBody().getObject();
        JSONArray names = jsonObject.getJSONObject("data").getJSONArray("names");
        JSONArray movieList = names.getJSONObject(0).getJSONArray("filmographies").getJSONObject(0).getJSONArray("filmography");
        String photo = names.getJSONObject(0).getString("urlPhoto");
        String name = names.getJSONObject(0).getString("name");

        ArrayList<Movie> movieArrayList = new ArrayList<>();



        for (int i = 0; i < movieList.length(); i++) { //iterate thru all of the actor's movies

            String title = movieList.getJSONObject(i).getString("title");
            String imdbid = movieList.getJSONObject(i).getString("imdbid");

            System.out.format("%20s%20s\n", title, imdbid);
/*
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

            } catch(Exception e){

            }
            //System.out.println(movieArrayList.size());*/
        }

        for (int i = 0; i < 10; i++) { //iterate thru all of the actor's movies and add to list

            String title = movieList.getJSONObject(i).getString("title");
            String imdbid = movieList.getJSONObject(i).getString("imdbid");
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

            } catch(Exception e){

            }
        }

        Actor actor = new Actor(name, photo, movieArrayList);

        return actor;
    }



    public static void main(String[] args) throws UnirestException {

        MovieParse mp = new MovieParse();
        Actor searched = mp.searchByActor(mp, "jennifer lawrence");
        System.out.println(searched.getName() + " : " + searched.getActorPhotos());
        for(int i = 0; i<searched.getMovies().size(); i++ ) {
            System.out.println(searched.getMovies().get(i).getTitle());
        }






    }
}
