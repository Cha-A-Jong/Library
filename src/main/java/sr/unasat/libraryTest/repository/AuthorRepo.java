package sr.unasat.libraryTest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryTest.entities.Author;

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

    public Author updateAuthor(Author author){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Author.class, author.getId());
            entityManager.merge(author);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return author;
    }

    public Author deleteAuthor(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Author.class, author.getId());
            if (author != null) entityManager.remove(author);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return author;
    }
}

