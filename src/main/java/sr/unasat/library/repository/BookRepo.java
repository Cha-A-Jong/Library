package sr.unasat.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.Book;
import sr.unasat.library.entities.Genre;

import java.util.List;

public class BookRepo {

    private EntityManager entityManager;

    public BookRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // alle records ophalen
//    public List<Book> getBook() {
//        String query = "select m from Member m";
//        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
//        List<Book> bookList = typedQuery.getResultList();
//        return bookList;
//    }

    public List<Book> getBook(){
        String query = "select b from Book b";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        List<Book> bookList = typedQuery.getResultList();
        return bookList;
    }

    //invoeren van een record
    public Book createBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return book;
    }
}
