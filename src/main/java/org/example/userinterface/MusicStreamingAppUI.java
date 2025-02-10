package org.example.userinterface;

import org.example.models.Album;
import org.example.models.Artist;
import org.example.service.AlbumService;
import org.example.service.ArtistsService;
import org.example.service.SongsService;
import org.example.models.Songs;
import org.example.service.PlaylistService;
import org.example.models.Playlist;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MusicStreamingAppUI {

    private ArtistsService artistsService;
    private AlbumService albumService;
    private SongsService songsService;
    private PlaylistService playlistService;

    public MusicStreamingAppUI(ArtistsService artistsService, AlbumService albumService, SongsService songsService, PlaylistService playlistService) {
        this.artistsService = artistsService;
        this.albumService = albumService;
        this.songsService = songsService;
        this.playlistService = playlistService;
    }
    Scanner scanner = new Scanner(System.in);

    private void showMenu() {
        System.out.println("Welcome to the Music Streaming");
        System.out.println("1. Show all artists");
        System.out.println("2. Show all albums");
        System.out.println("3. Show all songs");
        System.out.println("4. Create playlist");
        System.out.println("5. ListAllPlaylists");
        System.out.println("6. Find artist by name");
        System.out.println("5. Exit");
    }

    public void runMusicStreamingApp() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 7) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handledisplayAllArtists();
                    break;
                case 2:
                    handledisplayAllAlbums();
                    break;
                case 3:
                    handledisplayAllSongs();
                    break;
                case 4:
                    handlecreatePlaylist();
                    break;
                case 5:
                    handleListAllPlaylists();
                    break;
                case 6:
                    handlefindArtistByName();
                    break;
                
            }
        }
    }
    private void handledisplayAllArtists() {
        Iterable<Artist> artists = artistsService.getAllArtists();
        displayArtists(artists);
    }
    public void displayArtists(Iterable<Artist> artists) {
        for (Artist artist : artists){
            System.out.println(artist);
        }
    }

    private void handlefindArtistByName() {
        System.out.println("Enter artist name: ");
        String name = scanner.next();
        
        try{
            Artist artist = artistsService.getArtistByName(name);
            System.out.println(artist);
        }
        catch (Exception e){
            System.out.println("Artist not found");
        }
        
    }

    //handle displaying all albums
    private void handledisplayAllAlbums() {
        Iterable<Album> albums = albumService.getAllAlbums();
        displayAlbums(albums);
    }
    public void displayAlbums(Iterable<Album> albums) {
        for (Album album : albums){
            System.out.println(album);
        }
    }

    //handle displaying all songs
    private void handledisplayAllSongs(){
        Iterable<Songs> songs = songsService.getAllSongs();
        displaySongs(songs);
    }

    public void displaySongs(Iterable<Songs> songs) {
        for (Songs song : songs){
            System.out.println(song);
        }
    }


    //create playlist
    public void handlecreatePlaylist(){
        System.out.println("Enter playlist id:");
        int playlist_id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter playlist name:");
        String playlist_name = scanner.next();

        System.out .println("Enter no of songs you want to add to the playlist:");
        int no_of_songs = scanner.nextInt();

        List<Songs> playlist_songs = new ArrayList<>();

        for (int i = 0; i < no_of_songs; i++){

            System.out.println("Enter song id for song " + (i + 1) + ":");
            Integer song_id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter song name for song " + (i + 1) + ":");
            String song_name = scanner.nextLine();

            Songs song = new Songs();
            song.setSong_id(song_id.longValue());
            song.setSong_name(song_name);

            playlist_songs.add(song);
        }

        try {
            playlistService.createPlaylist(playlist_id, playlist_name, playlist_songs);
            System.out.println("Playlist created successfully");
        } catch (Exception e) {
            System.out.println("Failed to create playlist");    
        }
    }

    //list all playlists
    public void handleListAllPlaylists(){
        Iterable<Playlist> playlists = playlistService.listAllPlaylists();
        displayPlaylists(playlists);
        //return playlists;
    }

    public void displayPlaylists(Iterable<Playlist> playlists) {
        for (Playlist playlist : playlists){
            System.out.println(playlist);
        }
    }


}
