package org.example.models;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "albums")
public class Album{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> songs;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    //required by JPA spec to have a default constructor
    public Album() {
    }

    //constructor
    public Album(Long id, String title, int releaseYear, List<String> songs, Artist artist) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = songs;
        this.artist = artist;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    

    //Return a string representation of the object.
    @Override
    public String toString() {
        return "Artist {" + "id=" + id
                + ", title=" + (title != null ? title.trim() : "N/A") + "'"
                +", releaseYear=" + releaseYear +
                ", songs=" + songs
                + ", artist=" + (artist != null ? artist.getName().trim() : "N/A") +
                '}';
    }
}
