package org.example.service;

import org.example.models.Songs;
import org.example.repository.SongsRepository;


public class SongsService {

    private final SongsRepository songsRepository;

    public SongsService(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    public Iterable<Songs> getAllSongs() {
        return songsRepository.findAllSongs();
    }

}
