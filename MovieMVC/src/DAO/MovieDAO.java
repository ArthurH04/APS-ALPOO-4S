/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import infra.ConnectionFactory;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;
import model.Movie;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO implements IMovieDAO {

    private PreparedStatement ps = null;
    private Connection connection = null;

    @Override
    public void registerMovie(Movie movie) {

        String sql = "INSERT INTO movie (name, genre, synopsis, releaseDate) VALUES (?,?,?,?)";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, movie.getName());
            ps.setString(2, movie.getGenre());
            ps.setString(3, movie.getSynopsis());
            ps.setDate(4, new Date(movie.getReleaseDate().getTime()));
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public ArrayList<Movie> listMovies(String name) {
        ArrayList<Movie> movies = null;

        String sql = "SELECT * FROM movie WHERE name LIKE '%" + name + "%' ORDER BY movie_id";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            if (rs != null) {
                movies = new ArrayList<>();

                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt("movie_id"));
                    movie.setName(rs.getString("name"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setSynopsis(rs.getString("synopsis"));
                    movie.setReleaseDate(rs.getDate("releaseDate"));
                    movies.add(movie);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return movies;
    }

    @Override
    public void updateMovie(Movie movie) {

        String sql = "UPDATE movie SET name = ?, genre = ?, synopsis = ?, releaseDate = ? WHERE movie_id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, movie.getName());
            ps.setString(2, movie.getGenre());
            ps.setString(3, movie.getSynopsis());
            ps.setDate(4, new Date(movie.getReleaseDate().getTime()));
            ps.setInt(5, movie.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);

            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void deleteMovie(Movie movie) throws SQLIntegrityConstraintViolationException{
        String sql = "DELETE FROM movie WHERE movie_id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1, movie.getId());
            ps.execute();

        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;

        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);

            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
