/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLIntegrityConstraintViolationException;
import infra.ConnectionFactory;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import model.Actor;

public class ActorDAO implements IActorDAO {

    private PreparedStatement ps = null;
    private Connection connection = null;

    @Override
    public void registerActor(Actor actor) {

        String sql = "INSERT INTO actor (name, gender, nationality, birthDate) VALUES (?,?,?,?)";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, actor.getName());
            ps.setString(2, actor.getGender());
            ps.setString(3, actor.getNationality());
            ps.setDate(4, new Date(actor.getBirthDate().getTime()));
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
    public ArrayList<Actor> listActors(String name) {

        ArrayList<Actor> actors = null;

        String sql = "SELECT * FROM actor WHERE name LIKE '%" + name + "%' ORDER BY actor_id";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            if (rs != null) {
                actors = new ArrayList<>();

                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setId(rs.getInt("actor_id"));
                    actor.setName(rs.getString("name"));
                    actor.setGender(rs.getString("gender"));
                    actor.setNationality(rs.getString("nationality"));
                    actor.setBirthDate(rs.getDate("birthDate"));
                    actors.add(actor);
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

        return actors;
    }

    @Override
    public void updateActor(Actor actor) {

        String sql = "UPDATE actor SET name = ?, gender = ?, nationality = ?, birthDate = ? WHERE actor_id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, actor.getName());
            ps.setString(2, actor.getGender());
            ps.setString(3, actor.getNationality());
            ps.setDate(4, new Date(actor.getBirthDate().getTime()));
            ps.setInt(5, actor.getId());
            ps.execute();

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
    }

    @Override
    public void deleteActor(Actor actor) throws SQLIntegrityConstraintViolationException{

        String sql = "DELETE FROM actor WHERE actor_id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1, actor.getId());
            ps.execute();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw e;
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
