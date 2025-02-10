package org.example.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Playlist;;

public class PlaylistRepository {

    private Map<Integer, Playlist> playlist;


    public PlaylistRepository(){
        this.playlist = new HashMap<>();
    }

    public Playlist createPlaylist(Playlist playlist){
        this.playlist.put(playlist.getPlaylist_id(), playlist);
        return playlist;
    }

    public Playlist updatePlaylist(Playlist playlist){
        this.playlist.put(playlist.getPlaylist_id(), playlist);
        return playlist;
    }

    public void deletePlaylist(int playlist_id){
        this.playlist.remove(playlist_id);
    }

    public Iterable<Playlist> ListAllPlaylists(){
        return this.playlist.values();
    }



}
