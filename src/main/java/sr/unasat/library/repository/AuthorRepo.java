package sr.unasat.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.Author;

import java.util.List;

public class AuthorRepo {

    private EntityManager entityManager;

    public AuthorRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Author> getAuthor() {
        String query = "select a from Author a";
        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
        List<Author> authorList = typedQuery.getResultList();
        return authorList;
    }

    //finds author and book
    public Author findAuthorByLastName(String lastname) {
        entityManager.getTransaction().begin();
        String query = "select a from Author a where a.lastname = :lastname";
        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
        Author author = typedQuery.setParameter("lastname", lastname).getSingleResult();
        entityManager.getTransaction().commit();
        return author;
    }

//    public  Author findAuthorById(Long id) {
//        entityManager.getTransaction().begin();
//        String query = "delete from Author a where a.id = :id";
//        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
//        Author author = typedQuery.setParameter("id", id).getSingleResult();
//       entityManager.getTransaction().commit();
//       return author;
//    }

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

    public Author updateAuthor(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Author.class, author.getId());
            entityManager.merge(author);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return author;
    }

//    public int updateAuthor(Author author){
//        entityManager.getTransaction().begin();
//        String query = "update Author a set a.firstname = :firstname where a.lastname = :lastname";
//        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
//        typedQuery.setParameter("firstname", author.getFirstname());
//        typedQuery.setParameter("lastname", author.getLastname());
//        int rowsUpdated = typedQuery.executeUpdate();
//        System.out.println("author Updated: " + rowsUpdated);
//        entityManager.getTransaction().commit();
//        return rowsUpdated;
//    }

    public Author deleteAuthor(Author author) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Author.class, author.getId());
            if (author != null) {
                entityManager.remove(author);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return author;
    }

//    public int deleteAuthor(Author author){
//        entityManager.getTransaction().begin();
//        String query ="Delete from Author " + "Where id = :author_id";
//        TypedQuery<Author> typedQuery = entityManager.createQuery(query, Author.class);
//        typedQuery.setParameter("author_id",1);
//        int result = typedQuery.executeUpdate();
//        System.out.println("Rows affected: " + result);
//        entityManager.getTransaction().commit();
//        return result;
//    }
}

