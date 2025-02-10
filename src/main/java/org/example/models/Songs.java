package org.example.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;



@Entity
@Table(name = "songs")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long song_id;
    private String song_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private Artist artist_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private Album album_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    public Songs() {
    }

    public Songs(Long song_id, String song_name, Artist artist_name, Album album_name, Playlist playlist) {
        this.song_id = song_id;
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.album_name = album_name;
        this.playlist = playlist;
    }

    public Long getSong_id() {
        return song_id;
    }
    public void setSong_id(Long song_id) {
        this.song_id = song_id;
    }
    public String getSong_name() {
        return song_name;
    }
    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }
    public Artist getArtist_name() {
        return artist_name;
    }
    public void setArtist_name(Artist artist_name) {
        this.artist_name = artist_name;
    }
    public Album getAlbum_name() {
        return album_name;
    }
    public void setAlbum_name(Album album_name) {
        this.album_name = album_name;
    }
    public Playlist getPlaylist() {
        return playlist;
    }
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "song_id=" + song_id +
                ", song_name='" + song_name.trim()  + '\'' +
                ", artist_name='" + (artist_name != null ? artist_name.getName().trim() : "N/A") + '\'' +
                ", album_name='" + (album_name != null ? album_name.getTitle().trim() : "N/A") + '\'' +
                '}';
    }

}
