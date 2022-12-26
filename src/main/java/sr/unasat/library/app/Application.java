package sr.unasat.library.app;

import sr.unasat.library.entities.Author;
import sr.unasat.library.entities.Book;
import sr.unasat.library.service.*;

public class Application {

    public static void main(String[] args) {
//
//        DummyDataService.createDummyData();

//       BookService bookService = new BookService();
//        System.out.println(bookService.findBookByTitle("The Great Gatsby"));
//        System.out.println(bookService.findById(2L));
//
//        BookService bookService = new BookService();
//        bookService.deleteBook(book1);
//
//        bookService.updateBook(book1);
//        book1.setSubtitle("The Book Thief");

        AuthorService authorService = new AuthorService();
//        System.out.println(authorService.findAuthorByLastName("King"));
//
//        Author findAuthor = authorService.findAuthorByLastName("Rowling");
//        findAuthor.setFirstname("Mad");
//        findAuthor.setLastname("Lad");
//        authorService.updateAuthor(findAuthor);
//        System.out.println("The following records are updated: " + findAuthor);

        Author findAuthor = authorService.findAuthorByLastName("Lad");
       findAuthor.setId(1L);
       authorService.deleteAuthor(findAuthor);
        System.out.println("The following records are deleted: ");

//        List<Book> books = bookService.getBook();
//        books.forEach( book-> {
//            System.out.println("ISBN = " + book.getIsbn() + "|| Title = " + book.getTitle());
//        });

//        BookService.createBookAndBorrowReceipt();


   }
}
