/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import model.Actor;

public interface IActorDAO {
    
    void registerActor(Actor actor);
    ArrayList<Actor> listActors(String name);
    void updateActor(Actor actor);
    void deleteActor(Actor actor) throws SQLIntegrityConstraintViolationException;
    
}
