package com.LITH.sjwabackend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppProperties {
    private String marvelApiUrl;
    private String marvelApiPublicKey;
    private String marvelApiPrivateKey;

    public String getMarvelApiUrl() {
        return marvelApiUrl;
    }

    public void setMarvelApiUrl(String marvelApiUrl) {
        this.marvelApiUrl = marvelApiUrl;
    }

    public String getMarvelApiPublicKey() {
        return marvelApiPublicKey;
    }

    public void setMarvelApiPublicKey(String marvelApiPublicKey) {
        this.marvelApiPublicKey = marvelApiPublicKey;
    }

    public String getMarvelApiPrivateKey() {
        return marvelApiPrivateKey;
    }

    public void setMarvelApiPrivateKey(String marvelApiPrivateKey) {
        this.marvelApiPrivateKey = marvelApiPrivateKey;
    }
}
