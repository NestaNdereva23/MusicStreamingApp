package org.example.repository;

import org.example.models.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;

public class SongsJpaRepository extends SongsRepository {

    private EntityManagerFactory emf;

    public SongsJpaRepository() {
        this.emf = Persistence.createEntityManagerFactory("music-app");
    }

    @Override
    public Iterable<Songs> findAllSongs() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.createQuery("SELECT s FROM Songs s LEFT JOIN FETCH s.artist_name LEFT JOIN FETCH s.album_name", Songs.class)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
