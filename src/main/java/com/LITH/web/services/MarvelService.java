package com.LITH.web.services;

import com.LITH.web.daos.MarvelDao;
import com.LITH.web.interfaces.IMarvelDao;
import com.LITH.web.interfaces.IMarvelService;
import com.LITH.web.models.MarvelCharacter;

import java.util.List;

public class MarvelService implements IMarvelService {

    private final IMarvelDao marvelDao;

    public MarvelService(){this(new MarvelDao());}

    public MarvelService(IMarvelDao marvelDao){
        this.marvelDao = marvelDao;
    }

    public List<MarvelCharacter> GetAllCharacters() {
        List<MarvelCharacter> chars = marvelDao.GetAllCharacters();

        return chars;
    }
}
