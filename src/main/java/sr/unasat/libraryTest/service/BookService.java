package sr.unasat.libraryTest.service;

import sr.unasat.libraryTest.configuration.JPAConfig;
import sr.unasat.libraryTest.entities.Book;
import sr.unasat.libraryTest.repository.BookRepo;

import java.util.List;


public class BookService {

    private final BookRepo bookRepo;

    public BookService(){
        this.bookRepo = new BookRepo(JPAConfig.getEntityManager());
    }

    public List<Book> getBook(){
        return bookRepo.getBook();
    }

    public Book findBookByTitle(String title) {return bookRepo.findBookByTitle(title);}

    public Book createBook(Book book){
        return bookRepo.createBook(book);
    }

    public Book updateBook(Book book) {
        return bookRepo.updateBook(book);
    }

    public Book deleteBook(Book book) {
        return bookRepo.deleteBook(book);
    }

}
