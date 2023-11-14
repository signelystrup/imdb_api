package ita3.imdb_api.api;

import ita3.imdb_api.entity.Movie;
import ita3.imdb_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class MovieController {

    private MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api")
    public String apiDocumentation() {
        return "Movie API Endpoints:" +
                "\n- GET /api/movie: List all movies" +
                "\n- GET /api/movie/{id}: Get a movie by its ID" +
                "\n- POST /api/movie: Create a new movie" +
                "\n- PUT /api/movie/{id}: Update an existing movie" +
                "\n- DELETE /api/movie/{id}: Delete a movie";
    }

    @GetMapping("/api/movies")
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }

    @PutMapping("/api/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        Optional<Movie> existingMovie = repository.findById(id);
        if (existingMovie.isPresent()) {
            Movie updatedMovie = existingMovie.get();
            updatedMovie.setYear(movieDetails.getYear());
            updatedMovie.setLength(movieDetails.getLength());
            updatedMovie.setTitle(movieDetails.getTitle());
            updatedMovie.setSubject(movieDetails.getSubject());
            updatedMovie.setPopularity(movieDetails.getPopularity());
            updatedMovie.setAwards(movieDetails.isAwards());
            return ResponseEntity.ok(repository.save(updatedMovie));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
