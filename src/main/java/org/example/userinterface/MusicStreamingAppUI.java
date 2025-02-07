package org.example.userinterface;

import org.example.models.Artist;
import org.example.service.ArtistsService;

import java.util.Scanner;

public class MusicStreamingAppUI {

    private ArtistsService artistsService;

    public MusicStreamingAppUI(ArtistsService artistsService) {
        this.artistsService = artistsService;
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
                case 6:
                    handlefindArtistByName();
                    break;
                case 2,3,4:
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
        Artist artist = artistsService.getArtistByName(name);
        System.out.println(artist);
    }
}
