package org.example.models;

public class Artist extends Entity {

    private String genres;
    private String albums;

    public Artist(int id, String name, String genres, String albums) {
        super.id = id;
        super.name = name;
        this.genres = genres;
        this.albums = albums;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist {" + "id=" + id + ",name=" + (name != null ? name.trim() : "N/A") + "'" +",genres=" + (genres != null ? genres.trim() : "N/A") +
                ",albums=" + (albums != null ? albums.trim() : "N/A") +
                '}';
    }

}
