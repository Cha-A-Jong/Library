package sr.unasat.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.Author;
import sr.unasat.library.entities.Book;

import java.util.List;

public class AuthorRepo {

    private EntityManager entityManager;

    public AuthorRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Author> getAuthor(){
        String query = "select a from Author a";
        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
        List<Author> authorList = typedQuery.getResultList();
        return authorList;
    }

    //invoeren van een record
    public Author createAuthor(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return author;

  }
}

