package sr.unasat.library.service;

import sr.unasat.library.entities.*;

import java.util.List;

public class ReadUpdateDeleteForAllService {

    // Read all authors
    public static void RetrieveAuthor() {
        AuthorService authorService = new AuthorService();
        List<Author> authors = authorService.getAuthor();
        System.out.println(
                "-----------------------------------------"
        );

        authors.forEach(author ->
                System.out.format(
                        "\n" + "|| Author Firstname    :" + author.getFirstname() +
                                "\n" + "|| Author Lastname     :" + author.getLastname() +
                                "\n" + "|| Author Books        :" + author.getBooks() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");

    }

    // Update author
    public static void UpdateAuthor() {
        AuthorService authorService = new AuthorService();
        Author findAuthor = authorService.findAuthorByLastName("Lad");
        findAuthor.setFirstname("Joanna");
        findAuthor.setLastname("Rowling");
        authorService.updateAuthor(findAuthor);
    }

    // Delete author
    public static void DeleteAuthor() {
        AuthorService authorService = new AuthorService();
        Author author = new Author();
        author.setId(1L);
        authorService.deleteAuthor(author);
    }

    // Read all books
    public static void RetrieveBook() {
        BookService bookService = new BookService();
        List<Book> books = bookService.getBook();
        System.out.println(
                "-----------------------------------------"
        );

        books.forEach(book ->
                System.out.format(
                        "\n" + "|| Book ISBN     :" + book.getIsbn() +
                                "\n" + "|| Book Title    :" + book.getTitle() +
                                "\n" + "|| Book Subtitle :" + book.getSubtitle() +
                                "\n" + "|| Author        :" + book.getAuthor() +
                                "\n" + "|| BorrowReceipt :" + book.getBorrowReceipt() +
                                "\n" + "|| Genre         :" + book.getGenre() +
                                "\n" + "|| Member        :" + book.getMembers() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");

    }

    // Update book
    public static void UpdateBook() {
        BookService bookService = new BookService();
        Book findBookByTitle = bookService.findBookByTitle("The Great Gatsby");
        findBookByTitle.setSubtitle("All the bright precious things fade so fast");
        bookService.updateBook(findBookByTitle);
    }

    // Delete book
    public static void DeleteBook() {
        BookService bookService = new BookService();
        Book book = new Book();
        book.setId(1L);
        bookService.deleteBook(book);
    }

    // Read all BorrowReceipt
    public static void RetrieveBorrowReceipt() {
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        List<BorrowReceipt> borrowReceipts = borrowReceiptService.getBorrowReceipt();
        System.out.println(
                "-----------------------------------------"
        );

        borrowReceipts.forEach(borrowReceipt ->
                System.out.format(
                        "\n" + "|| BorrowReceipt borrow_date               :" + borrowReceipt.getBorrow_date() +
                                "\n" + "|| BorrowReceipt Due_Date          :" + borrowReceipt.getDue_date() +
                                "\n" + "|| BorrowReceipt Receipt_Number    :" + borrowReceipt.getReceipt_number() +
                                "\n" + "|| BorrowReceipt remark            :" + borrowReceipt.getRemark() +
                                "\n" + "|| Member                          :" + borrowReceipt.getMember() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");

    }

    // Update BorrowReceipt
    public static void UpdateBorrowReceipt() {
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        BorrowReceipt findBorrowReceiptByReceiptNumber = borrowReceiptService.findBorrowReceiptByReceiptNumber("2022-001");
        findBorrowReceiptByReceiptNumber.setReceipt_number("2022-000");
        borrowReceiptService.updateBorrowReceipt(findBorrowReceiptByReceiptNumber);
    }

    // Delete BorrowReceipt
    public static void DeleteBorrowReceipt() {
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        BorrowReceipt borrowReceipt = new BorrowReceipt();
        borrowReceipt.setId(1L);
        borrowReceiptService.deleteBorrowReceipt(borrowReceipt);
    }

    // Read all Genre
    public static void RetrieveGenre() {
        GenreService genreService = new GenreService();
        List<Genre> genres = genreService.getGenre();
        System.out.println(
                "-----------------------------------------"
        );

        genres.forEach(genre ->
                System.out.format(
                        "\n" + "|| Genres       :" + genre.getName() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");

    }

    //Update Genre
    public static void UpdateGenre() {
        GenreService genreService = new GenreService();
        Genre findGenreByName = genreService.findGenreByName("Tragedy");
        findGenreByName.setName("Drama");
        genreService.updateGenre(findGenreByName);
    }

    public static void DeleteGenre() {
        GenreService genreService = new GenreService();
        Genre genre = new Genre();
        genre.setId(1L);
        genreService.deleteGenre(genre);
    }

    // Read all Member
    public static void RetrieveMember() {
        MemberService memberService = new MemberService();
        List<Member> members = memberService.getMember();
        System.out.println(
                "-----------------------------------------"
        );

        members.forEach(member ->
                System.out.format(
                                "\n" + "|| Member firstname     :" + member.getFirstname() +
                                "\n" + "|| Member lastname      :" + member.getLastname() +
                                "\n" + "|| Member DateOfBirth   :" + member.getDate_of_birth() +
                                "\n" + "|| Member CBBIdNumber   :" + member.getCbb_id_number() +
                                "\n" + "|| Member LibraryNumber :" + member.getLibrary_number() +
                                "\n\n"
                ));
        System.out.println(
                "-----------------------------------------");

    }

    public static void UpdateMember() {
        MemberService memberService = new MemberService();
        Member findMemberByLastName = memberService.findMemberByLastName("Cha-A-Jong");
        findMemberByLastName.setLastname("Wirjo");
        memberService.updateMember(findMemberByLastName);
    }

    public static void DeleteMember() {
        MemberService memberService = new MemberService();
        Member member = new Member();
        member.setId(1L);
        memberService.deleteMember(member);
    }


}

