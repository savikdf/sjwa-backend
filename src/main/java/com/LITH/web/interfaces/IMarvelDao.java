package com.LITH.web.interfaces;

import com.LITH.web.models.MarvelCharacter;

import java.util.List;

public interface IMarvelDao {
    List<MarvelCharacter> GetAllCharacters();
}
