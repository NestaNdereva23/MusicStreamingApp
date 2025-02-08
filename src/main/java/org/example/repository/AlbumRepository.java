package org.example.repository;

import org.example.models.Album;

import java.util.HashMap;
import java.util.Map;

public class AlbumRepository {

    private Map<Long, Album> albums;

    public AlbumRepository() {
        this.albums = new HashMap<>();
    }

    public Iterable<Album> findAllAlbums() {
        return albums.values();
    }
}
