# Movie Manager - Module 8 DMS Project

This is a command-line Java application developed for the Module 8 Database Management System (DMS) assignment at Valencia College. It allows users to manage a collection of movies using CRUD operations, a custom feature, and robust input validation. JUnit tests are included to validate core functionality.

## Features
- Load movies from a `.txt` file
- Display all movies
- Add a movie manually
- Update any movie’s fields
- Delete a movie by title
- Show average duration of all movies (custom feature)
- Prevent crashes with input validation and exception handling
- Unit tests for all major features

## File Format
The application supports importing movie data from a text file. Each line in the file must follow this format:
title,genre,year,rating,duration,available

### Example:
Inception,Sci-Fi,2010,8.8,148,true
Titanic,Romance,1997,7.8,195,true
The Matrix,Sci-Fi,1999,8.7,136,true


## How to Run

### In IntelliJ IDEA
1. Open the project in IntelliJ IDEA.
2. Right-click `Main.java` and select **Run 'Main.main()'**.
3. When prompted, enter the name of the file (e.g. `movies_sample_data.txt`).

### In Terminal
1. Navigate to the JAR location:
```bash
cd /Users/luisaugustomonserratt/IdeaProjects/module\ 8/out/artifacts/module_8_jar
java -jar "module 8.jar"
When prompted, type:

movies_sample_data.txt
Unit Testing
Unit tests are provided in MovieManagerTest.java using JUnit 5. These tests validate:

Adding valid and invalid movies

Updating movies

Deleting movies

Calculating average duration

Run Unit Tests in IntelliJ
Open MovieManagerTest.java.

Right-click and select Run 'MovieManagerTest'.

Requirements Checklist
 CLI Menu with CRUD operations and custom action

 Validates all user input

 Cannot crash from invalid input

 Loads data from a file

 File format validated

 Displays all records

 Performs average duration (custom action)

 Includes complete unit testing

 Submitted as .zip, .jar, sample data file, GitHub repo, and video

Author
Luis Augusto Monserratt Alvarado
GitHub: https://github.com/luismonserratt/module-8-dms
Valencia College – COP3330C – Module 8 Assignment
