package com.LITH.sjwabackend.web.interfaces;

import com.LITH.sjwabackend.web.models.Character;
import com.LITH.sjwabackend.web.models.WrappedCharacter;

import java.util.List;

public interface IMarvelDao {
    List<WrappedCharacter> GetAllCharacters();
    WrappedCharacter GetCharacter(int characterId);
}
