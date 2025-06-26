import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MovieManager class
 */
public class MovieManagerTest {

    private MovieManager manager;

    @BeforeEach
    void setup() {
        manager = new MovieManager();
    }

    @Test
    void testCreateMovieSuccess() {
        boolean result = manager.createMovie("Inception", "Sci-Fi", 2010, 8.8, 148, true);
        assertTrue(result);
    }

    @Test
    void testCreateMovieInvalidData() {
        boolean result = manager.createMovie("", "Action", 1500, -1, -50, true);
        assertFalse(result);
    }

    @Test
    void testUpdateMovieSuccess() {
        manager.createMovie("Avatar", "Sci-Fi", 2009, 7.9, 162, true);
        boolean result = manager.updateMovie("Avatar", "Fantasy", 2010, 8.1, 165, false);
        assertTrue(result);
    }

    @Test
    void testUpdateMovieNotFound() {
        boolean result = manager.updateMovie("Nonexistent", "Horror", 2000, 7.0, 100, true);
        assertFalse(result);
    }

    @Test
    void testUpdateMovieInvalidData() {
        manager.createMovie("Titanic", "Romance", 1997, 7.8, 195, true);
        boolean result = manager.updateMovie("Titanic", "", 1400, -2, 0, false);
        assertFalse(result);
    }

    @Test
    void testDeleteMovieSuccess() {
        manager.createMovie("Coco", "Animation", 2017, 8.4, 105, true);
        boolean result = manager.deleteMovie("Coco");
        assertTrue(result);
    }

    @Test
    void testDeleteMovieNotFound() {
        boolean result = manager.deleteMovie("DoesNotExist");
        assertFalse(result);
    }

    @Test
    void testGetAverageDurationWithMovies() {
        manager.createMovie("Movie A", "Drama", 2010, 7.5, 120, true);
        manager.createMovie("Movie B", "Comedy", 2012, 7.0, 100, true);
        double avg = manager.getAverageDuration();
        assertEquals(110.0, avg, 0.01);
    }

    @Test
    void testGetAverageDurationWithNoMovies() {
        double avg = manager.getAverageDuration();
        assertEquals(0.0, avg, 0.01);
    }
}
