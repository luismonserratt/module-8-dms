// MovieManager.java
// Handles all movie management logic (CRUD + custom actions)

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of Movie objects and provides CRUD operations
 * and a custom action to calculate average duration.
 */
public class MovieManager {
    private List<Movie> movies = new ArrayList<>();

    /**
     * Adds a movie after validating its data.
     */
    public boolean createMovie(String title, String genre, int year, double rating, int duration, boolean available) {
        if (title == null || title.isBlank() || genre == null || genre.isBlank()
                || year < 1800 || rating < 0 || rating > 10 || duration <= 0) {
            return false;
        }
        Movie movie = new Movie(title, genre, year, rating, duration, available);
        movies.add(movie);
        return true;
    }

    /**
     * Updates an existing movie if found and data is valid.
     */
    public boolean updateMovie(String title, String newGenre, int newYear, double newRating, int newDuration, boolean newAvailability) {
        Movie movie = findMovie(title);
        if (movie == null || newGenre == null || newGenre.isBlank()
                || newYear < 1800 || newRating < 0 || newRating > 10 || newDuration <= 0) {
            return false;
        }
        movie.setGenre(newGenre);
        movie.setYear(newYear);
        movie.setRating(newRating);
        movie.setDuration(newDuration);
        movie.setAvailable(newAvailability);
        return true;
    }

    /**
     * Deletes a movie by title (case-insensitive).
     */
    public boolean deleteMovie(String title) {
        return movies.removeIf(m -> m.getTitle().equalsIgnoreCase(title));
    }

    /**
     * Finds a movie by its title.
     */
    public Movie findMovie(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Displays all movies in the system.
     */
    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies found.");
        } else {
            for (Movie m : movies) {
                System.out.println(m);
            }
        }
    }

    /**
     * Custom feature: calculates and prints the average duration of all movies.
     */
    public void printAverageDuration() {
        if (movies.isEmpty()) {
            System.out.println("No movies to calculate.");
        } else {
            double avg = getAverageDuration();
            System.out.printf("Average duration: %.2f minutes\n", avg);
        }
    }

    /**
     * Returns the average duration of all movies.
     */
    public double getAverageDuration() {
        if (movies.isEmpty()) return 0;
        double total = 0;
        for (Movie m : movies) {
            total += m.getDuration();
        }
        return total / movies.size();
    }

    /**
     * Returns a copy of the list of movies (for testing or displaying).
     */
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }
}
