package sr.unasat.library.app;

import jakarta.persistence.EntityManager;
import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Book;
import sr.unasat.library.entities.Genre;
import sr.unasat.library.entities.Member;
import sr.unasat.library.service.BookService;
import sr.unasat.library.service.BorrowReceiptService;
import sr.unasat.library.service.GenreService;
import sr.unasat.library.service.MemberService;

public class Application {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        GenreService genreService = new GenreService();

        Genre genre = new Genre();
        genre.setName("Fantasy");

        Genre genres = genreService.createGenre(genre);

        Book createBook = new Book();
        createBook.setIsbn("152663788X");
        createBook.setTitle("Harry Potter and the Chamber of Secrets");
        createBook.setAuthor("J.K.Rowling");

        createBook.setGenreId(genres);
        bookService.createBook(createBook);
    }
}
