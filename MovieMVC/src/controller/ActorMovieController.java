/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ActorMovieDAO;
import java.util.ArrayList;
import model.Actor;
import model.ActorMovie;
import model.Movie;

/**
 *
 * @author arthur
 */
public class ActorMovieController {

    public boolean associateActorMovie(int actorId, int movieId) {
        if (actorId > 0 && movieId > 0) {
            Actor actor = new Actor();
            actor.setId(actorId);

            Movie movie = new Movie();
            movie.setId(movieId);

            ActorMovie actorMovie = new ActorMovie(actor, movie);
            actorMovie.associateActorMovie(actorMovie);
            return true;
        }
        return false;
    }

    public ArrayList<ActorMovie> listActorMovies(String movieName) {
        return new ActorMovieDAO().listActorMovie(movieName);
    }

    public boolean deleteActorMovie(int actorId, int movieId) {
        if (actorId == 0 && movieId == 0) {
            return false;
        } else {
            ActorMovie actorMovie = new ActorMovie();

            Actor actor = new Actor();
            actor.setId(actorId);

            Movie movie = new Movie();
            movie.setId(movieId);

            actorMovie.setActor(actor);
            actorMovie.setMovie(movie);

            actorMovie.deleteActorMovie(actorMovie);
            return true;
        }

    }

}
