package com.LITH.sjwabackend.web.daos;

import com.LITH.sjwabackend.web.interfaces.IMarvelDao;
import com.LITH.sjwabackend.web.models.*;
import com.LITH.sjwabackend.web.models.Character;
import com.LITH.sjwabackend.web.utilities.MD5Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MarvelDao implements IMarvelDao {

    //region Vars

    private RestTemplate restTemplate = new RestTemplate();

    private final String marvelAPIURL = "https://gateway.marvel.com:443/v1/public/characters";
    private final String marvelPublicKey = "whyAreYouLookingHere";
    private final String marvelPrivateKey = "no no no";

    //endregion

   public List<WrappedCharacter> GetAllCharacters(){

        long ts = new Date().getTime();
        String stringToHash = ts + marvelPrivateKey + marvelPublicKey;
        String hashAsString = MD5Utils.ConvertStringToMD5HexString(stringToHash);
        String baseUrl = marvelAPIURL;
        int limit = 15;
        String url = baseUrl + "?limit=" + limit + "&offset=" + 209 + "&ts=" + ts + "&apikey=" + marvelPublicKey + "&hash=" + hashAsString;
        System.out.println(url);


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        List<WrappedCharacter> characters = new ArrayList<WrappedCharacter>();

        //Parse Json into our Models
        try {
           JSONObject jResponse = new JSONObject(result.getBody());
           JSONObject  jData = jResponse.getJSONObject ("data");
           JSONArray jResultsArray= jData.getJSONArray("results");

           if (jResultsArray != null) {
               ObjectMapper objectMapper = new ObjectMapper();
               for (int i=0;i<jResultsArray.length();i++){
                    //character
                   Character character = objectMapper.readValue(jResultsArray.getString(i), Character.class);

                   //comics
                   JSONObject jComicWrapper = jResultsArray.getJSONObject(i).getJSONObject ("comics");
                   JSONArray jComicArray= jComicWrapper.getJSONArray("items");
                   Comic[] comics = objectMapper.readValue(jComicArray.toString(), Comic[].class);

                   //series
                   JSONObject jSeriesWrapper = jResultsArray.getJSONObject(i).getJSONObject ("series");
                   JSONArray jSeriesArray= jSeriesWrapper.getJSONArray("items");
                   Series[] series = objectMapper.readValue(jSeriesArray.toString(), Series[].class);

                   //stories
                   JSONObject jStoriesWrapper = jResultsArray.getJSONObject(i).getJSONObject ("stories");
                   JSONArray jStoriesArray= jStoriesWrapper.getJSONArray("items");
                   Story[] stories = objectMapper.readValue(jStoriesArray.toString(), Story[].class);

                   //events
                   JSONObject jEventsWrapper = jResultsArray.getJSONObject(i).getJSONObject ("stories");
                   JSONArray jEventsArray= jEventsWrapper.getJSONArray("items");
                   Event[] events = objectMapper.readValue(jEventsArray.toString(), Event[].class);

                   //wrap it all together here
                   WrappedCharacter wrappedCharacter = new WrappedCharacter();
                   wrappedCharacter.setCharacter(character);
                   wrappedCharacter.setComics(comics);
                   wrappedCharacter.setSeries(series);
                   wrappedCharacter.setStories(stories);
                   wrappedCharacter.setEvents(events);

                   characters.add(wrappedCharacter);
               }
           }
        }
       catch (JSONException | JsonProcessingException e) {
           e.printStackTrace();
       }

       return characters;

       //https://gateway.marvel.com:443/v1/public/characters
        // ?name=name
        // &nameStartsWith=nameStartsWith
        // &modifiedSince=modifiedSince
        // &comics=comics
        // &series=series
        // &events=events
        // &stories=stories
        // &orderBy=name
        // &limit=limit
        // &offset=offset
        // &apikey=xxxxx
    }


    public WrappedCharacter GetCharacter(int characterId){
        WrappedCharacter temp = new WrappedCharacter();
        return temp;
    }
}
