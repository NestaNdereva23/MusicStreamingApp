package org.example;

import org.example.models.Playlist;
import org.example.repository.AlbumJpaRepository;
import org.example.repository.ArtistJpaRepository;
//import org.example.repository.ArtistDBRepository;
import org.example.repository.ArtistRepository;
import org.example.repository.PlaylistJpaRepository;
import org.example.repository.SongsJpaRepository;
//import org.example.repository.DatabaseConnection;
import org.example.service.AlbumService;
import org.example.service.ArtistsService;
import org.example.service.PlaylistService;
import org.example.service.SongsService;
import org.example.userinterface.MusicStreamingAppUI;

public class Main {
    public static void main(String[] args) {

        //ArtistDBRepository artistDBRepository = new ArtistDBRepository();
        //ArtistRepository artistRepository = new ArtistRepository();
        ArtistJpaRepository artistJpaRepository= new ArtistJpaRepository();
        ArtistsService artistsService = new ArtistsService( artistJpaRepository);

        AlbumJpaRepository albumJpaRepository = new AlbumJpaRepository();
        AlbumService albumService = new AlbumService(albumJpaRepository);

        //songs
        SongsJpaRepository songsJpaRepository = new SongsJpaRepository();
        SongsService songsService = new SongsService(songsJpaRepository);

        //playlist
        PlaylistJpaRepository playlistJpaRepository = new PlaylistJpaRepository();
        PlaylistService playlistService = new PlaylistService(playlistJpaRepository);
        

        MusicStreamingAppUI musicStreamingAppUI = new MusicStreamingAppUI(artistsService, albumService, songsService, playlistService);

        musicStreamingAppUI.runMusicStreamingApp();

    }
}