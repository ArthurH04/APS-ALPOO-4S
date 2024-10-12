/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLIntegrityConstraintViolationException;
import DAO.MovieDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Movie;

public class MovieController {

    public boolean registerMovie(String name, String genre, String synopsis, String releaseDate) throws ParseException {

        if (name != null && name.length() > 0 && genre != null && genre.length() > 0 && synopsis != null && synopsis.length() > 0 && releaseDate != null && releaseDate.length() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = simpleDateFormat.parse(releaseDate);

            Movie movie = new Movie(name, genre, synopsis, date);
            movie.registerMovie(movie);

            return true;
        }
        return false;
    }

    public ArrayList<Movie> listMovies(String name) {
        return new MovieDAO().listMovies(name);
    }

    public boolean updateMovie(int id, String name, String genre, String synopsis, String releaseDate) throws ParseException {
        if (name != null && name.length() > 0 && genre != null && genre.length() > 0 && synopsis != null && synopsis.length() > 0 && releaseDate != null && releaseDate.length() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = simpleDateFormat.parse(releaseDate);

            Movie movie = new Movie(name, genre, synopsis, date);
            movie.setId(id);
            movie.updateMovie(movie);

            return true;
        }
        return false;
    }

    public boolean deleteMovie(int id) throws SQLIntegrityConstraintViolationException{
        if (id == 0) {
            return false;
        } else {
            Movie movie = new Movie();
            movie.setId(id);
            movie.deleteMovie(movie);
            return true;
        }
    }
}
