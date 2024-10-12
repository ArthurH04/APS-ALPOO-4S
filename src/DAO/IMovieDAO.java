/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import model.Movie;

/**
 *
 * @author arthur
 */
public interface IMovieDAO {
    
    void registerMovie(Movie movie);
    ArrayList<Movie> listMovies(String movie);
    void updateMovie(Movie movie);
    void deleteMovie(Movie movie) throws SQLIntegrityConstraintViolationException;
    
}
