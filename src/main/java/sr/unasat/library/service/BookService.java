package sr.unasat.library.service;

import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Book;
import sr.unasat.library.repository.BookRepo;

import java.util.List;


public class BookService {

    private final BookRepo bookRepo;

    public BookService(){
        this.bookRepo = new BookRepo(JPAConfig.getEntityManager());
    }

    public List<Book> getBook(){
        return bookRepo.getBook();
    }

    public Book createBook(Book book){
        return bookRepo.createBook(book);
    }
}
