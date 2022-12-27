package sr.unasat.library.service;

import sr.unasat.library.entities.*;

public class DummyDataService {

    public static void createDummyData(){

        //Create book
        BookService bookService = new BookService();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();

        book1.setIsbn("152663788X");
        book1.setTitle("Harry Potter and the Chamber of Secrets");

        book2.setIsbn("9054294485");
        book2.setTitle("Hoe duur was de suiker?");

        book3.setIsbn("1501143514");
        book3.setTitle("The Dark Tower 1");
        book3.setSubtitle("The Gunslinger");

        book4.setIsbn("0547928203");
        book4.setTitle("The lord of the rings");
        book4.setSubtitle("The two towers");

        book5.setIsbn("9798745274824");
        book5.setTitle("The Great Gatsby");

        bookService.createBook(book1);
        bookService.createBook(book2);
        bookService.createBook(book3);
        bookService.createBook(book4);
        bookService.createBook(book5);

        // Create genre
        GenreService genreService = new GenreService();

        Genre genre1 = new Genre();
        genre1.setName("Fantasy");
        Genre genres1 = genreService.createGenre(genre1);
        book1.setGenre(genres1);

        Genre genre2 = new Genre();
        genre2.setName("Roman");
        Genre genres2 = genreService.createGenre(genre2);
        book2.setGenre(genres2);

        Genre genre3 = new Genre();
        genre3.setName("Fantasy");
        Genre genres3 = genreService.createGenre(genre3);
        book3.setGenre(genres3);

        Genre genre4 = new Genre();
        genre4.setName("Fantasy");
        Genre genres4 = genreService.createGenre(genre4);
        book4.setGenre(genres4);

        Genre genre5 = new Genre();
        genre5.setName("Tragedy");
        Genre genres5 = genreService.createGenre(genre5);
        book5.setGenre(genres5);

        genreService.createGenre(genre1);
        genreService.createGenre(genre2);
        genreService.createGenre(genre3);
        genreService.createGenre(genre4);
        genreService.createGenre(genre5);

        // Create author
        AuthorService authorService = new AuthorService();
        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();
        Author author4 = new Author();
        Author author5 = new Author();

        author1.setFirstname("Joanna");
        author1.setLastname("Rowling");
        Author authors1 = authorService.createAuthor(author1);
        book1.setAuthor(authors1);

        author2.setFirstname("Cynthia");
        author2.setLastname("McLeod");
        Author authors2 = authorService.createAuthor(author2);
        book2.setAuthor(authors2);

        author3.setFirstname("Stephen");
        author3.setLastname("King");
        Author authors3 = authorService.createAuthor(author3);
        book3.setAuthor(authors3);

        author4.setFirstname("John Ronald Reuel");
        author4.setLastname("Tolkien");
        Author authors4 = authorService.createAuthor(author4);
        book4.setAuthor(authors4);

        author5.setFirstname("Francis Scott");
        author5.setLastname("Fitzgerald");
        Author authors5 = authorService.createAuthor(author5);
        book5.setAuthor(authors5);

        authorService.createAuthor(author1);
        authorService.createAuthor(author2);
        authorService.createAuthor(author3);
        authorService.createAuthor(author4);
        authorService.createAuthor(author5);

        // Create member
        MemberService memberService = new MemberService();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();

        member1.setFirstname("Chanelle");
        member1.setLastname("Cha-A-Jong");
        member1.setDate_of_birth("14-02-1990");
        member1.setLibrary_number("202212001");
        member1.setCbb_id_number("FI000794");

        member2.setFirstname("Ashwin");
        member2.setLastname("Adhin");
        member2.setDate_of_birth("10-06-1980");
        member2.setLibrary_number("202211002");
        member2.setCbb_id_number("BA080211");

        member3.setFirstname("Bronto");
        member3.setLastname("Somohardjo");
        member3.setDate_of_birth("20-01-1980");
        member3.setLibrary_number("202212003");
        member3.setCbb_id_number("DA000123");

        member4.setFirstname("Chan");
        member4.setLastname("Santokhi");
        member4.setDate_of_birth("03-02-1959");
        member4.setLibrary_number("202212002");
        member4.setCbb_id_number("AB000111");

        member5.setFirstname("Ronnie");
        member5.setLastname("Brunswijk");
        member5.setDate_of_birth("07-03-1961");
        member5.setLibrary_number("202211001");
        member5.setCbb_id_number("BO004587");

        memberService.createMember(member1);
        memberService.createMember(member2);
        memberService.createMember(member3);
        memberService.createMember(member4);
        memberService.createMember(member5);

        //Create Join table book_member
        member1.getBooks().add(book1);
        book1.getMembers().add(member1);

        member2.getBooks().add(book2);
        book2.getMembers().add(member2);

        member3.getBooks().add(book3);
        book3.getMembers().add(member3);

        member4.getBooks().add(book4);
        book4.getMembers().add(member4);

        member5.getBooks().add(book5);
        book5.getMembers().add(member5);

        //Create borrowreceipt
        BorrowReceiptService borrowReceiptService = new BorrowReceiptService();
        BorrowReceipt borrowReceipt1 = new BorrowReceipt();
        BorrowReceipt borrowReceipt2 = new BorrowReceipt();
        BorrowReceipt borrowReceipt3 = new BorrowReceipt();
        BorrowReceipt borrowReceipt4 = new BorrowReceipt();
        BorrowReceipt borrowReceipt5 = new BorrowReceipt();

        borrowReceipt1.setReceipt_number("2022-001");
        borrowReceipt1.setBorrow_date("08-12-2022");
        borrowReceipt1.setDue_date("15-12-2022");
        borrowReceipt1.setRemark("laat ingeleverd");
        //relatie tussen BorrowReceipt en Member
        BorrowReceipt borrowReceipts1 = borrowReceiptService.createBorrowReceipt(borrowReceipt1);
        member1.setBorrowReceipt(borrowReceipts1);
        //relatie tussen BorrowReceipt en Book
        BorrowReceipt borrowReceiptbook1 = borrowReceiptService.createBorrowReceipt(borrowReceipt1);
        book1.setBorrowReceipt(borrowReceiptbook1);

        borrowReceipt2.setReceipt_number("2022-002");
        borrowReceipt2.setBorrow_date("05-12-2022");
        borrowReceipt2.setDue_date("12-12-2022");
        borrowReceipt2.setRemark("boek beschadigd");
        BorrowReceipt borrowReceipts2 = borrowReceiptService.createBorrowReceipt(borrowReceipt2);
        member2.setBorrowReceipt(borrowReceipts2);
        BorrowReceipt borrowReceiptbook2 = borrowReceiptService.createBorrowReceipt(borrowReceipt2);
        book2.setBorrowReceipt(borrowReceiptbook2);

        borrowReceipt3.setReceipt_number("2022-003");
        borrowReceipt3.setBorrow_date("01-12-2022");
        borrowReceipt3.setDue_date("08-12-2022");
        borrowReceipt3.setRemark("laat ingeleverd");
        BorrowReceipt borrowReceipts3 = borrowReceiptService.createBorrowReceipt(borrowReceipt3);
        member3.setBorrowReceipt(borrowReceipts3);
        BorrowReceipt borrowReceiptbook3 = borrowReceiptService.createBorrowReceipt(borrowReceipt3);
        book3.setBorrowReceipt(borrowReceiptbook3);

        borrowReceipt4.setReceipt_number("2022-004");
        borrowReceipt4.setBorrow_date("01-11-2022");
        borrowReceipt4.setDue_date("08-11-2022");
        borrowReceipt4.setRemark("laat ingeleverd");
        BorrowReceipt borrowReceipts4 = borrowReceiptService.createBorrowReceipt(borrowReceipt4);
        member4.setBorrowReceipt(borrowReceipts4);
        BorrowReceipt borrowReceiptbook4 = borrowReceiptService.createBorrowReceipt(borrowReceipt4);
        book4.setBorrowReceipt(borrowReceiptbook4);

        borrowReceipt5.setReceipt_number("2022-005");
        borrowReceipt5.setBorrow_date("22-11-2022");
        borrowReceipt5.setDue_date("29-11-2022");
        borrowReceipt5.setRemark("boek verloren");
        BorrowReceipt borrowReceipts5 = borrowReceiptService.createBorrowReceipt(borrowReceipt5);
        member5.setBorrowReceipt(borrowReceipts5);
        BorrowReceipt borrowReceiptbook5 = borrowReceiptService.createBorrowReceipt(borrowReceipt5);
        book5.setBorrowReceipt(borrowReceiptbook5);

        borrowReceiptService.createBorrowReceipt(borrowReceipt1);
        borrowReceiptService.createBorrowReceipt(borrowReceipt2);
        borrowReceiptService.createBorrowReceipt(borrowReceipt3);
        borrowReceiptService.createBorrowReceipt(borrowReceipt4);
        borrowReceiptService.createBorrowReceipt(borrowReceipt5);
    }
}
