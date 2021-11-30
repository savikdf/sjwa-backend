package com.LITH.sjwabackend.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic {
    private String resourceUri;
    private String name;

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
