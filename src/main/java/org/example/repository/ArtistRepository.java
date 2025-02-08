package org.example.repository;

import org.example.models.Artist;

import java.util.HashMap;
import java.util.Map;

public class ArtistRepository {

    private Map<Integer, Artist> artists;

    public ArtistRepository() {
        this.artists = new HashMap<>();
    }

    public Iterable<Artist> findAllArtists() {
        return artists.values();
    }

    public Artist findByName(String name) {
        for (Artist artist : artists.values()) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return null;
    }
}
