package com.LITH.sjwabackend.web.models;

public class WrappedCharacter {
    private Character character;
    private Comic[] comics;
    private Series[] series;
    private Story[] stories;
    private Event[] events;
    private Url[] urls;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Comic[] getComics() {
        return comics;
    }

    public void setComics(Comic[] comics) {
        this.comics = comics;
    }

    public Series[] getSeries() {
        return series;
    }

    public void setSeries(Series[] series) {
        this.series = series;
    }

    public Story[] getStories() {
        return stories;
    }

    public void setStories(Story[] stories) {
        this.stories = stories;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Url[] getUrls() {
        return urls;
    }

    public void setUrls(Url[] urls) {
        this.urls = urls;
    }
}
