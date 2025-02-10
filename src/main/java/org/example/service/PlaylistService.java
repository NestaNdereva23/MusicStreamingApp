package org.example.service;

import org.example.models.Playlist;
import org.example.repository.PlaylistRepository;
import org.example.models.Songs;
import java.util.List;



public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(int playlist_id, String playlist_name, List<Songs> playlist_songs) {
        Playlist playlist = new Playlist(playlist_id, playlist_name, playlist_songs);
        return playlistRepository.createPlaylist(playlist);
    }

    public Iterable<Playlist> listAllPlaylists() {
        return playlistRepository.ListAllPlaylists();
    }
    
}
