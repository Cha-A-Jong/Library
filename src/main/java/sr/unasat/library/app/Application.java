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
        BookService bookService = new BookService();
        GenreService genreService = new GenreService();
        AuthorService authorService = new AuthorService();
        MemberService memberService = new MemberService();

        Genre genre = new Genre();
        genre.setName("Fantasy");

        Author author = new Author();
        author.setFirstname("Joanna");
        author.setLastname("Rowling");

        Member member = new Member();
        member.setFirstname("Chanelle");
        member.setLastname("Cha-A-Jong");
        member.setDate_of_birth("1990-02-11");
        member.setLibrary_number("202212001");
        member.setCbb_id_nummer("FI000794");

        Genre genres = genreService.createGenre(genre);
        Author authors = authorService.createAuthor(author);

        Book createBook = new Book();
        createBook.setIsbn("152663788X");
        createBook.setTitle("Harry Potter and the Chamber of Secrets");

        createBook.setGenreId(genres);
        createBook.setAuthorId(authors);

        bookService.createBook(createBook);

        List<Book> books = bookService.getBook();
        books.forEach( book-> {
            System.out.println("ISBN = " + book.getIsbn() + "|| Title = " + book.getTitle());
        });


    }
}
