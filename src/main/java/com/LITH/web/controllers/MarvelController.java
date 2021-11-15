package com.LITH.web.controllers;

import com.LITH.web.interfaces.IMarvelService;
import com.LITH.web.models.MarvelCharacter;
import com.LITH.web.services.MarvelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarvelController {

    private final IMarvelService marvelService;

    public MarvelController(){ this(new MarvelService()); }
    public MarvelController(IMarvelService marvelService){
        this.marvelService = marvelService;
    }

    @GetMapping("/api/v1/marvel/characters")
    @ResponseBody
    public ResponseEntity<?> GetAllCharacters(){
        try{
            List<MarvelCharacter> chars = marvelService.GetAllCharacters();

            return ResponseEntity.ok().body(chars);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
        }
    }

}
