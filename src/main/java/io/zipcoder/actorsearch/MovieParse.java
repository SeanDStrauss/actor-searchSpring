package io.zipcoder.actorsearch;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by BatComputer on 11/2/15.
 */
public class MovieParse {
    private HttpResponse<JsonNode> response;
    public HttpResponse<JsonNode> makeRequest(String actName) {
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
        MovieParse mp = new MovieParse();
        mp.makeRequest("julia roberts");
        System.out.println();
        Actor actor = new Actor();
        System.out.println(mp.getResponse().getBody().getObject().getJSONArray("title"));







    }
}
