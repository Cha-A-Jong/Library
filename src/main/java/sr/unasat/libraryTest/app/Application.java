package sr.unasat.libraryTest.app;

import sr.unasat.libraryTest.entities.*;
import sr.unasat.libraryTest.service.*;

public class Application {

    public static void main(String[] args) {

        DummyDataService.createDummyData();

//        List<Book> books = bookService.getBook();
//        books.forEach( book-> {
//            System.out.println("ISBN = " + book.getIsbn() + "|| Title = " + book.getTitle());
//        });

   }
}