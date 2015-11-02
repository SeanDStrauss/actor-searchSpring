package io.zipcoder.actorsearch;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Objects;

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

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public void setResponse(HttpResponse<JsonNode> response) {
        this.response = response;
    }


    public static void main(String[] args) throws UnirestException {
        MovieParse actorParser = new MovieParse();
        HttpResponse<JsonNode> actor = actorParser.makeActorRequest("brad pitt");

        JSONObject jsonObject = actorParser.getResponse().getBody().getObject();
        JSONArray names = jsonObject.getJSONObject("data").getJSONArray("names");
        JSONArray movieList = names.getJSONObject(0).getJSONArray("filmographies").getJSONObject(0).getJSONArray("filmography");

        for (int i = 0; i < movieList.length(); i++) { //iterate thru all of the actor's movies

            Movie movie = new Movie(movieList.getJSONObject(i).getString("title"),
                                    movieList.getJSONObject(i).getString("imdbid"),
                                    movieList.getJSONObject(i).getString("year"));
            System.out.println(movie.getTitle() + " : " + movie.getReleaseYear());

        }

    }
}
