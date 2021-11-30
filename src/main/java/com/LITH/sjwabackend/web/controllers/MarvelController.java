package com.LITH.sjwabackend.web.controllers;

import com.LITH.sjwabackend.web.interfaces.IMarvelService;
import com.LITH.sjwabackend.web.models.Character;
import com.LITH.sjwabackend.web.models.WrappedCharacter;
import com.LITH.sjwabackend.web.services.MarvelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000") //this is not production ready
public class MarvelController {

    private final IMarvelService marvelService;

    public MarvelController(){ this(new MarvelService()); }
    public MarvelController(IMarvelService marvelService){
        this.marvelService = marvelService;
    }

    @RequestMapping(value = "/api/v1/marvel/characters", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> GetAllCharacters(){
        try{
            List<WrappedCharacter> chars = marvelService.GetAllCharacters();

            return ResponseEntity.ok().body(chars);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }

    @RequestMapping(value = "/api/v1/marvel/characters/{characterID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> GetCharacter(int characterId){
        try{
            WrappedCharacter character = marvelService.GetCharacter(characterId);

            return ResponseEntity.ok().body(character);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }
}
