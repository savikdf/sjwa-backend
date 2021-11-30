package com.LITH.sjwabackend.web.services;

import com.LITH.sjwabackend.web.daos.MarvelDao;
import com.LITH.sjwabackend.web.interfaces.IMarvelDao;
import com.LITH.sjwabackend.web.interfaces.IMarvelService;
import com.LITH.sjwabackend.web.models.Character;
import com.LITH.sjwabackend.web.models.Thumbnail;
import com.LITH.sjwabackend.web.models.WrappedCharacter;

import java.util.List;

public class MarvelService implements IMarvelService {

    private final IMarvelDao marvelDao;

    public MarvelService(){this(new MarvelDao());}

    public MarvelService(IMarvelDao marvelDao){
        this.marvelDao = marvelDao;
    }

    public List<WrappedCharacter> GetAllCharacters() {
        List<WrappedCharacter> characters = marvelDao.GetAllCharacters();

        for(WrappedCharacter c : characters){
            if((c.getCharacter().getThumbnail().getPath()).contains("image_not_available")){
                c.getCharacter().setThumbnail(new Thumbnail());
            }
        }

        return characters;
    }

    public WrappedCharacter GetCharacter(int characterId) {
        WrappedCharacter character = marvelDao.GetCharacter(characterId);

        return character;
    }
}
