package com.LITH.sjwabackend.web.daos;

import com.LITH.sjwabackend.web.interfaces.IMarvelDao;
import com.LITH.sjwabackend.web.models.MarvelCharacter;

import java.util.*;

public class MarvelDao implements IMarvelDao {
    public List<MarvelCharacter> GetAllCharacters(){
        List<MarvelCharacter> chars = new ArrayList<>();
        MarvelCharacter temp;

        for(int i = 0; i < 3; i++){
            temp = new MarvelCharacter();
            temp.setCharID(i+1);
            temp.setName("Character " + i);
            temp.setDescription("Description " + i);
            temp.setImgUri("Uri " + i);
            chars.add(temp);
        }

        //going to be using this api:

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

        return chars;
    }
}
