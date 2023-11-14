package ita3.imdb_api.config;

import ita3.imdb_api.entity.Movie;
import ita3.imdb_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    private MovieRepository repository;
    private static final List<Movie> MOVIES = Arrays.asList(
            new Movie(1963, 138, "8 1/2", "Drama", 80, true),
            new Movie(1968, 139, "2001: A Space Odyssey", "Science Fiction", 83, false),
            new Movie(1982, 92, "48 Hrs.", "Action", 67, false),
            new Movie(1966, 95, "A Big Hand for the Little Lady", "Comedy", 12, false),
            new Movie(1992, 60, "A Certain Sacrifice", "Music", 24, false),
            new Movie(1962, 105, "A Child Is Waiting", "Drama", 60, false),
            new Movie(1985, 118, "A Chorus Line, The Movie", "Music", 71, false),
            new Movie(1990, 89, "A Chorus of Disapproval", "Comedy", 0, false),
            new Movie(1971, 138, "A Clockwork Orange", "Science Fiction", 83, true),
            new Movie(1967, 100, "A Coeur Joie, (Head Over Heels)", "Action", 54, false),
            new Movie(1988, 122, "A Cry in the Dark", "Drama", 67, false),
            new Movie(1992, 96, "A Day in October", "Drama", 76, false),
            new Movie(1989, 97, "A Dry White Season", "Drama", 71, false),
            new Movie(1966, 104, "A Fine Madness", "Comedy", 6, false),
            new Movie(1988, 108, "A Fish Called Wanda", "Comedy", 7, true),
            new Movie(1964, 102, "A Fistful of Dollars", "Westerns", 61, false),
            new Movie(1954, 96, "A Lesson in Love", "Comedy", 48, false),
            new Movie(1977, 110, "A Little Night Music", "Music", 61, false),
            new Movie(1966, 103, "A Man & a Woman", "Drama", 46, true));

    public DeveloperData(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        repository.saveAll(MOVIES);
    }

}



