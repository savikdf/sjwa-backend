package com.LITH.web.models;

public class MarvelCharacter {

    private int charID;
    private String name;
    private String description;
    private String imgUri;

    //region Getters and Setters

    public int getCharID() {
        return charID;
    }

    public void setCharID(int charID) {
        this.charID = charID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    //endregion



}
