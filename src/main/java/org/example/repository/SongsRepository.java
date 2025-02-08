package org.example.repository;
import java.util.Map;

import org.example.models.Songs;

import java.util.HashMap;

public class SongsRepository {

    private Map<Long, Songs> songs;

    public SongsRepository() {
        this.songs = new HashMap<>();
    }

    public Iterable<Songs> findAllSongs() {
        return songs.values();
    }

}
