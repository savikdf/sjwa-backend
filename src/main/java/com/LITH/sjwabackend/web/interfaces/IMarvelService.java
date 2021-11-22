package com.LITH.sjwabackend.web.interfaces;

import com.LITH.sjwabackend.web.models.MarvelCharacter;

import java.util.List;

public interface IMarvelService {
    List<MarvelCharacter> GetAllCharacters();
    MarvelCharacter GetCharacter(int characterId);
}
