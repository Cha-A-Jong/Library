package sr.unasat.library.service;

import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Book;
import sr.unasat.library.entities.Genre;
import sr.unasat.library.repository.GenreRepo;

import java.util.List;

public class GenreService {
    private final GenreRepo genreRepo;

    public GenreService(){
        this.genreRepo = new GenreRepo(JPAConfig.getEntityManager());
    }

    public List<Genre> getGenre() {return  genreRepo.getGenre();}

    public Genre findGenreByName(String name) {return genreRepo.findGenreByName(name);}

    public Genre createGenre(Genre genre){
        return genreRepo.createGenre(genre);
    }

    public Genre updateGenre(Genre genre) {
        return genreRepo.updateGenre(genre);
    }

    public Genre deleteGenre(Genre genre) {
        return genreRepo.deleteGenre(genre);
    }
}
