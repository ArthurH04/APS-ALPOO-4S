/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLIntegrityConstraintViolationException;
import DAO.MovieDAO;
import java.util.ArrayList;
import java.util.Date;

public class Movie {

    private int id;
    private String name;
    private String genre;
    private String synopsis;
    private Date releaseDate;

    public Movie() {
        
    }
    
    public Movie(String name, String genre, String synopsis, Date releaseDate) {
        this.name = name;
        this.genre = genre;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void registerMovie(Movie movie) {
        new MovieDAO().registerMovie(movie);
    }

    public ArrayList<Movie> listMovies(String name) {
        return new MovieDAO().listMovies(name);
    }

    public void updateMovie(Movie movie) {
        new MovieDAO().updateMovie(movie);
    }

    public void deleteMovie(Movie movie) throws SQLIntegrityConstraintViolationException {
        new MovieDAO().deleteMovie(movie);
    }
}
