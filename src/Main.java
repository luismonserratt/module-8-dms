import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main application class. Provides a CLI menu to interact with MovieManager.
 */
public class Main {
    private static final MovieManager manager = new MovieManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            printMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number:");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> loadFromFile();
                case 2 -> manager.displayMovies();
                case 3 -> createMovie();
                case 4 -> updateMovie();
                case 5 -> deleteMovie();
                case 6 -> manager.printAverageDuration();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    /**
     * Prints the menu options for the user.
     */
    private static void printMenu() {
        System.out.println("\n--- Movie Manager ---");
        System.out.println("1. Load movies from file");
        System.out.println("2. Display all movies");
        System.out.println("3. Add a movie");
        System.out.println("4. Update a movie");
        System.out.println("5. Delete a movie");
        System.out.println("6. Show average duration (custom feature)");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    /**
     * Allows the user to add a new movie manually.
     */
    private static void createMovie() {
        try {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Rating (0–10): ");
            double rating = Double.parseDouble(scanner.nextLine());
            System.out.print("Duration (minutes): ");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.print("Available (true/false): ");
            boolean available = Boolean.parseBoolean(scanner.nextLine());

            boolean success = manager.createMovie(title, genre, year, rating, duration, available);

            if (success) System.out.println("Movie added.");
            else System.out.println("Invalid data. Movie not added.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Movie not added.");
        }
    }

    /**
     * Allows the user to update an existing movie.
     */
    private static void updateMovie() {
        System.out.print("Enter title of movie to update: ");
        String title = scanner.nextLine();
        try {
            System.out.print("New Genre: ");
            String genre = scanner.nextLine();
            System.out.print("New Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("New Rating: ");
            double rating = Double.parseDouble(scanner.nextLine());
            System.out.print("New Duration: ");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.print("Available (true/false): ");
            boolean available = Boolean.parseBoolean(scanner.nextLine());

            boolean success = manager.updateMovie(title, genre, year, rating, duration, available);

            if (success) System.out.println("Movie updated.");
            else System.out.println("Invalid data or movie not found.");
        } catch (Exception e) {
            System.out.println("Invalid input. Update failed.");
        }
    }

    /**
     * Deletes a movie by title.
     */
    private static void deleteMovie() {
        System.out.print("Enter title of movie to delete: ");
        String title = scanner.nextLine();
        if (manager.deleteMovie(title)) {
            System.out.println("Movie deleted.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    /**
     * Loads movies from a text file into the system.
     * Expected format per line: title,genre,year,rating,duration,available
     */
    private static void loadFromFile() {
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();
        try {
            File file = new File(path);
            Scanner fileScanner = new Scanner(file);
            int count = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length != 6) continue;

                String title = data[0].trim();
                String genre = data[1].trim();
                int year = Integer.parseInt(data[2].trim());
                double rating = Double.parseDouble(data[3].trim());
                int duration = Integer.parseInt(data[4].trim());
                boolean available = Boolean.parseBoolean(data[5].trim());

                boolean success = manager.createMovie(title, genre, year, rating, duration, available);
                if (success) count++;
            }
            System.out.println(count + " movies loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}
