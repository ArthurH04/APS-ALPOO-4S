/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.ActorMovie;

/**
 *
 * @author arthur
 */
public interface IActorMovie {
    
    void associateActorMovie(ActorMovie actorMovie);
    ArrayList<ActorMovie> listActorMovie(String movieName);
    void deleteActorMovie(ActorMovie actorMovie);
    
}
