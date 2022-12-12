package sr.unasat.libraryTest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryTest.entities.Book;

import java.util.List;

public class BookRepo {

    private EntityManager entityManager;

    public BookRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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

    public Book deleteBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.find(Book.class, book.getId());
            if (book != null) entityManager.remove(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return book;
    }

    public Book updateBook(Book book){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Book.class, book.getId());
            entityManager.merge(book);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return book;
    }
}
