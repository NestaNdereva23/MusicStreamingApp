package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import org.example.models.Artist;

public class ArtistJpaRepository extends ArtistRepository {

    private final EntityManagerFactory emf;

    public ArtistJpaRepository(){

        this.emf = Persistence.createEntityManagerFactory("music-app");
    }

    @Override
    public List<Artist> findAllArtists() {

        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT a FROM Artist a LEFT JOIN FETCH a.genres", Artist.class)
                    .getResultList();
//            return em.createQuery("from Artist", Artist.class).getResultList();
        } finally {
            emf.close();
        }
    }

    @Override
    public Artist findByName(String name) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT a FROM Artist a WHERE a.name = :name", Artist.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            emf.close();
        }
    }

}
