package sr.unasat.libraryTest.service;

import sr.unasat.libraryTest.configuration.JPAConfig;
import sr.unasat.libraryTest.entities.Author;
import sr.unasat.libraryTest.repository.AuthorRepo;

import java.util.List;

public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService() { this.authorRepo = new AuthorRepo(JPAConfig.getEntityManager());}

    public List<Author> getAuthor(){
        return authorRepo.getAuthor();
    }

    public Author createAuthor(Author author){
        return authorRepo.createAuthor(author);
    }

    public Author updateAuthor(Author author) {
        return authorRepo.updateAuthor(author);
    }

    public Author deleteAuthor(Author author) {
        return authorRepo.deleteAuthor(author);
    }
}
