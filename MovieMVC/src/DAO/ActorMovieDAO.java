/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import infra.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Actor;
import model.ActorMovie;
import model.Movie;

/**
 *
 * @author arthur
 */
public class ActorMovieDAO implements IActorMovie {

    private PreparedStatement ps = null;
    private Connection connection = null;

    @Override
    public void associateActorMovie(ActorMovie actorMovie) {
        String sql = "INSERT INTO actormovie (actor_id, movie_id) VALUES (?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1, actorMovie.getActor().getId());
            ps.setInt(2, actorMovie.getMovie().getId());
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
    public ArrayList<ActorMovie> listActorMovie(String movieName) {

        String sql = "SELECT a.actor_id, a.name AS actor_name, m.movie_id, m.name as movie_name"
                + " FROM actormovie am"
                + " INNER JOIN actor a ON a.actor_id = am.actor_id"
                + " INNER JOIN movie m ON m.movie_id = am.movie_id"
                + " WHERE m.name = ?";

        ArrayList<ActorMovie> actorMovies = null;

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, movieName);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                actorMovies = new ArrayList<>();

                while (rs.next()) {
                    Actor actor = new Actor();
                    Movie movie = new Movie();
                    ActorMovie actorMovie = new ActorMovie();

                    actor.setId(rs.getInt("actor_id"));
                    actor.setName(rs.getString("actor_name"));

                    movie.setId(rs.getInt("movie_id"));
                    movie.setName(rs.getString("movie_name"));

                    actorMovie.setActor(actor);
                    actorMovie.setMovie(movie);

                    actorMovies.add(actorMovie);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return actorMovies;
    }

    @Override
    public void deleteActorMovie(ActorMovie actorMovie) {
        String sql = "DELETE FROM actormovie WHERE actor_id = ? AND movie_id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1, actorMovie.getActor().getId());
            ps.setInt(2, actorMovie.getMovie().getId());
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

}
