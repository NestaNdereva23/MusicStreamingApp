package org.example.models;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlist_id;
    private String playlist_name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "playlist")   
    private List<Songs> playlist_songs;


    public Playlist() {
    }

    public Playlist(Integer playlist_id, String playlist_name, List<Songs> playlist_songs) {
        this.playlist_id = playlist_id;
        this.playlist_name = playlist_name;
        this.playlist_songs = playlist_songs;
    }

    public Integer getPlaylist_id() {
        return playlist_id;
    }
    public void setPlaylist_id(Integer playlist_id) {
        this.playlist_id = playlist_id;
    }
    public String getPlaylist_name() {
        return playlist_name;
    }
    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }
    public List<Songs> getPlaylist_songs() {
        return playlist_songs;
    }
    public void setPlaylist_songs(List<Songs> playlist_songs) {
        this.playlist_songs = playlist_songs;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlist_id=" + playlist_id +
                ", playlist_name='" + playlist_name + '\'' +
                ", playlist_songs=" + (playlist_songs) +
                '}';
    }

}
