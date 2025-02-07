package org.example.models;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "artists")
public class Artist{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> genres;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Album> albums;

    public Artist(Long id, String name, List<String> genres, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.albums = albums;
    }

    public Artist() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist {" + "id=" + id + ",name=" + (name != null ? name.trim() : "N/A") + "'" +",genres=" + genres  +
                ",albums=" + albums +
                '}';
    }

}
