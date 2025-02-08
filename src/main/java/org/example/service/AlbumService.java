package org.example.service;

import org.example.models.Album;
import org.example.repository.AlbumRepository;

public class AlbumService {

    AlbumRepository albumRepository = new AlbumRepository();

    public AlbumService (AlbumRepository albumRepository ) {
        this.albumRepository = albumRepository;
    }

    public Iterable<Album> getAllAlbums() {
        return albumRepository.findAllAlbums();
    }
}
