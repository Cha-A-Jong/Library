package sr.unasat.library.service;

import sr.unasat.library.configuration.JPAConfig;
import sr.unasat.library.entities.Genre;
import sr.unasat.library.repository.GenreRepo;

public class GenreService {
    private final GenreRepo genreRepo;

    public GenreService(){
        this.genreRepo = new GenreRepo(JPAConfig.getEntityManager());
    }

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
