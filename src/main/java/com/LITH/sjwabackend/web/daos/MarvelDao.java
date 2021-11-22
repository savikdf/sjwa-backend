package com.LITH.sjwabackend.web.daos;

import com.LITH.sjwabackend.web.interfaces.IMarvelDao;
import com.LITH.sjwabackend.web.models.MarvelCharacter;

import java.util.*;

public class MarvelDao implements IMarvelDao {
    public List<MarvelCharacter> GetAllCharacters(){
        List<MarvelCharacter> chars = new ArrayList<>();
        MarvelCharacter temp;

        for(int i = 0; i < 20; i++){
            temp = new MarvelCharacter();
            temp.setCharacterId(i+1);
            temp.setName("Character " + i);
            temp.setDescription("Description " + i);
            if(i % 2 == 0)
                temp.setFavorite(true);
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
    public MarvelCharacter GetCharacter(int characterId){
        MarvelCharacter temp = new MarvelCharacter();

        //don't worry, this is temporary
        temp.setCharacterId(characterId);
        temp.setDescription("This guy got hit with a big ol' wad of Atomic energy, and became " +
                "a wad man. Capable of creating wads consisting of anything, " +
                "he is a menace to society");


        return temp;
    }
}
