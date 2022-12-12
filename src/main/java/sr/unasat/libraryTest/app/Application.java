package sr.unasat.libraryTest.app;

import sr.unasat.libraryTest.entities.*;
import sr.unasat.libraryTest.service.*;

public class Application {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        GenreService genreService = new GenreService();
        AuthorService authorService = new AuthorService();
        MemberService memberService = new MemberService();
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();

        Genre genre = new Genre();
        genre.setName("Fantasy");

        Author author = new Author();
        author.setFirstname("Joanna");
        author.setLastname("Rowling");

        Member member = new Member();
        member.setFirstname("Chanelle");
        member.setLastname("Cha-A-Jong");
        member.setDate_of_birth("14-02-1990");
        member.setLibrary_number("202212001");
        member.setCbb_id_nummer("FI000794");

        BorrowReceipt borrowReceiptObj = new BorrowReceipt();
        borrowReceiptObj.setReceipt_number("2022-001");
        borrowReceiptObj.setBorrow_date("08-12-2022");
        borrowReceiptObj.setDue_date("15-12-2022");
        borrowReceiptObj.setRemark("laat ingeleverd");

        Genre genres = genreService.createGenre(genre);
        Author authors = authorService.createAuthor(author);
        Member members = memberService.createMember(member);
        BorrowReceipt borrowReceipts = borrowReceiptService.createBorrowReceipt(borrowReceiptObj);

        Book createBookObj = new Book();
        createBookObj.setIsbn("152663788X");
        createBookObj.setTitle("Harry Potter and the Chamber of Secrets");
        createBookObj.setGenre(genres);
        createBookObj.setAuthor(authors);

        bookService.createBook(createBookObj);
        memberService.createMember(members);
        borrowReceiptService.createBorrowReceipt(borrowReceipts);

//        List<Book> books = bookService.getBook();
//        books.forEach( book-> {
//            System.out.println("ISBN = " + book.getIsbn() + "|| Title = " + book.getTitle());
//        });

   }
}
