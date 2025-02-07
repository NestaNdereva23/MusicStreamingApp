package org.example;

import org.example.repository.ArtistDBRepository;
import org.example.repository.DatabaseConnection;
import org.example.service.ArtistsService;
import org.example.userinterface.MusicStreamingAppUI;

public class Main {
    public static void main(String[] args) {

        ArtistDBRepository artistDBRepository = new ArtistDBRepository();
        ArtistsService artistsService = new ArtistsService(artistDBRepository);

        MusicStreamingAppUI musicStreamingAppUI = new MusicStreamingAppUI(artistsService);

        musicStreamingAppUI.runMusicStreamingApp();

    }
}