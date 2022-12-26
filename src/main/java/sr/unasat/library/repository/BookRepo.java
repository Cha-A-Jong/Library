package sr.unasat.library.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.library.entities.Author;
import sr.unasat.library.entities.Book;
import sr.unasat.library.entities.BorrowReceipt;

import java.util.List;
import java.util.Optional;

public class BookRepo {

    private EntityManager entityManager;

    public BookRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //find all books
    public List<Book> getBook(){
        String query = "select b from Book b";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        List<Book> bookList = typedQuery.getResultList();
        return bookList;
    }

    public Book findBookByTitle (String title){
        entityManager.getTransaction().begin();
        String query = "select b from Book b where b.title = :title";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        Book book = typedQuery.setParameter("title", title).getSingleResult();
        entityManager.getTransaction().commit();
        return book;
    }

    public Optional<Book> findById(Long id){
        Book book = entityManager.find(Book.class,id);
        return book != null ? Optional.of(book) : Optional.empty();
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

    public Book createBookAndBorrowReceipt(){
        Book book = Book.builder().isbn("9054294485").title("Hoe duur was de suiker?").
                author(Author.builder().firstname("Cynthia").lastname("McLeod").build()).
                borrowReceipt(BorrowReceipt.builder().receipt_number("2022-006").borrow_date("05-12-2022").due_date("12-12-2022").build()).build();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        return book;
    }
}
