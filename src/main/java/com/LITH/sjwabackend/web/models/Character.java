package com.LITH.sjwabackend.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    private int id;
    private String name;
    private String description;
    private Thumbnail thumbnail;
    private String resourceUri;


    //region Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    //endregion

    @Override
    public String toString() {
        return "Name: " + name + ", Id: " + id;
    }
}
