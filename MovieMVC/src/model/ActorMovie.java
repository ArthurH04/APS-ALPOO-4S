/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.ActorMovieDAO;

/**
 *
 * @author arthur
 */
public class ActorMovie {
    private Actor actor;
    private Movie movie;
    
    public ActorMovie() {
        
    }

    public ActorMovie(Actor actor, Movie movie) {
        this.actor = actor;
        this.movie = movie;
    }
    
    

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public void associateActorMovie(ActorMovie actorMovie) {
        new ActorMovieDAO().associateActorMovie(actorMovie);
    }

    public void deleteActorMovie(ActorMovie actorMovie){
        new ActorMovieDAO().deleteActorMovie(actorMovie);
    }
}
