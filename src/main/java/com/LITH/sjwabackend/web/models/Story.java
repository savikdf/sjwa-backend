package com.LITH.sjwabackend.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Story {
    private String esourceUri;
    private String name;
    private String type;

    public String getEsourceUri() {
        return esourceUri;
    }

    public void setEsourceUri(String esourceUri) {
        this.esourceUri = esourceUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
