package sr.unasat.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.Book;
import sr.unasat.library.entities.Genre;

import java.util.List;

public class GenreRepo {

    private EntityManager entityManager;

    public GenreRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // alle records ophalen
    public List<Genre> getGenre() {
        String query = "select g from Genre g";
        TypedQuery<Genre> typedQuery = entityManager.createQuery(query, Genre.class);
        List<Genre> genreList = typedQuery.getResultList();
        return genreList;
    }

    public Genre findGenreByName (String name){
        entityManager.getTransaction().begin();
        String query = "select g from Genre g where g.name = :name";
        TypedQuery<Genre> typedQuery = entityManager.createQuery(query, Genre.class);
        Genre genre = typedQuery.setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        return genre;
    }

    //invoeren van een record
    public Genre createGenre(Genre genre) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(genre);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return genre;
    }

    public Genre updateGenre(Genre genre){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Genre.class, genre.getId());
            entityManager.merge(genre);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return genre;
    }

    public Genre deleteGenre(Genre genre) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Genre.class, genre.getId());
            if (genre != null) entityManager.remove(genre);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return genre;
    }
}


