package org.example.repository;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;

import org.example.models.Playlist;
import org.example.models.Songs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;


public class PlaylistJpaRepository extends PlaylistRepository {

    private EntityManagerFactory emf;

    public PlaylistJpaRepository() {
        super();
        this.emf = Persistence.createEntityManagerFactory("music-app");
    }

    public Playlist createPlaylist (int playlist_id, String playlist_name, List<Songs> playlist_songs){
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Playlist playlist = new Playlist();
            playlist.setPlaylist_id(playlist_id);
            playlist.setPlaylist_name(playlist_name);

            for (Songs song : playlist_songs) {
                song.setPlaylist(playlist);
            }
            playlist.setPlaylist_songs(playlist_songs);

            em.persist(playlist);
            em.getTransaction().commit();
            return playlist;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw  new RuntimeException("Error creating playlist", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    //list all playlists
    @Override
    public Iterable<Playlist> ListAllPlaylists() {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            return em.createQuery("SELECT p FROM Playlist p LEFT JOIN FETCH p.playlist_songs", Playlist.class)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


}
