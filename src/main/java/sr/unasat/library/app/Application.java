package sr.unasat.library.app;

import jakarta.persistence.EntityManager;
import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Author;
import sr.unasat.library.entities.Book;
import sr.unasat.library.entities.Genre;
import sr.unasat.library.entities.Member;
import sr.unasat.library.service.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {
//        BookService bookService = new BookService();
//        GenreService genreService = new GenreService();
//
//        Genre genre = new Genre();
//        genre.setName("Fantasy");
//
//        Genre genres = genreService.createGenre(genre);
//
//        Book createBook = new Book();
//        createBook.setIsbn("152663788X");
//        createBook.setTitle("Harry Potter and the Chamber of Secrets");
//        createBook.setAuthor("J.K.Rowling");
//
//        createBook.setGenreId(genres);
//        bookService.createBook(createBook);
//
//        List<Book> books = bookService.getBook();
//        books.forEach( book-> {
//            System.out.println("ISBN = " + book.getIsbn() + "|| Title = " + book.getTitle());
//        });

        AuthorService authorService = new AuthorService();
        Author authorObj = new Author();
        authorObj.setName("Rowling");
        authorObj.setFirstname("Joanna");

        List<Author> authors = authorService.getAuthor();
        authors.forEach( author-> {
            System.out.println("ISBN = " + author.getName() + "|| Title = " + author.getFirstname());
        });

    }
}
