package org.example.service;

import org.example.models.Artist;
//import org.example.repository.ArtistDBRepository;
import org.example.repository.ArtistRepository;

public class ArtistsService {

    private final ArtistRepository artistRepository;

    public ArtistsService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Iterable<Artist> getAllArtists() {
        return artistRepository.findAllArtists();
    }

    public Artist getArtistByName(String name) {
        return artistRepository.findByName(name);
    }
}
