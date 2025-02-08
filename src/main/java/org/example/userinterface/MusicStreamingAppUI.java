package org.example.userinterface;

import org.example.models.Album;
import org.example.models.Artist;
import org.example.service.AlbumService;
import org.example.service.ArtistsService;

import java.util.Scanner;

public class MusicStreamingAppUI {

    private ArtistsService artistsService;
    private AlbumService albumService;

    public MusicStreamingAppUI(ArtistsService artistsService, AlbumService albumService) {
        this.artistsService = artistsService;
        this.albumService = albumService;
    }
    Scanner scanner = new Scanner(System.in);

    private void showMenu() {
        System.out.println("Welcome to the Music Streaming");
        System.out.println("1. Show all artists");
        System.out.println("2. Show all albums");
        System.out.println("3. Show all songs");
        System.out.println("4. Show all playlists");
        System.out.println("6. Find artist by name");
        System.out.println("5. Exit");
    }

    public void runMusicStreamingApp() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 5) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handledisplayAllArtists();
                    break;
                case 2:
                    handledisplayAllAlbums();
                    break;
                case 6:
                    handlefindArtistByName();
                    break;
                case 3,4:
                    System.out.println("Not implemented yet");
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

}
