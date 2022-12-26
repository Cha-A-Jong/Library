package sr.unasat.library.service;

import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Author;
import sr.unasat.library.repository.AuthorRepo;

import java.util.List;

public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService() { this.authorRepo = new AuthorRepo(JPAConfig.getEntityManager());}

    public List<Author> getAuthor(){
        return authorRepo.getAuthor();
    }

    public Author findAuthorByLastName(String lastname) {return authorRepo.findAuthorByLastName(lastname);}

//    public Author findAuthorById(Long id) {return  authorRepo.findAuthorById(id);}

    public Author createAuthor(Author author){
        return authorRepo.createAuthor(author);
    }

    public Author updateAuthor(Author author) {return authorRepo.updateAuthor(author);}

    public int deleteAuthor(Author author) {
        return authorRepo.deleteAuthor(author);
    }

}
