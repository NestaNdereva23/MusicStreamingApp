package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Album;

import java.util.List;

public class AlbumJpaRepository extends AlbumRepository{

    private final EntityManagerFactory emf;

    public AlbumJpaRepository() {
        this.emf = Persistence.createEntityManagerFactory("music-app");
    }

    @Override
    public List<Album> findAllAlbums() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            //fetch all results eagerly
            return em.createQuery("SELECT a FROM Album a LEFT JOIN FETCH a.artist LEFT JOIN FETCH a.songs", Album.class)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
