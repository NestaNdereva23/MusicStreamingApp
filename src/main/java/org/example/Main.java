package org.example;

import org.example.repository.AlbumJpaRepository;
import org.example.repository.ArtistJpaRepository;
//import org.example.repository.ArtistDBRepository;
import org.example.repository.ArtistRepository;
//import org.example.repository.DatabaseConnection;
import org.example.service.AlbumService;
import org.example.service.ArtistsService;
import org.example.userinterface.MusicStreamingAppUI;

public class Main {
    public static void main(String[] args) {

        //ArtistDBRepository artistDBRepository = new ArtistDBRepository();
        ArtistRepository artistRepository = new ArtistRepository();
        ArtistJpaRepository artistJpaRepository= new ArtistJpaRepository();
        ArtistsService artistsService = new ArtistsService( artistJpaRepository);

        AlbumJpaRepository albumJpaRepository = new AlbumJpaRepository();
        AlbumService albumService = new AlbumService(albumJpaRepository);
        

        MusicStreamingAppUI musicStreamingAppUI = new MusicStreamingAppUI(artistsService, albumService);

        musicStreamingAppUI.runMusicStreamingApp();

    }
}