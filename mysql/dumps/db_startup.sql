CREATE DATABASE IF NOT EXISTS box;

USE box;

CREATE TABLE IF NOT EXISTS Actor (
                                     actor_id INTEGER PRIMARY KEY auto_increment,
                                     name VARCHAR(40),
    gender VARCHAR(15),
    nationality VARCHAR(20),
    birthDate DATE
    );

CREATE TABLE IF NOT EXISTS Movie (
                                     movie_id INTEGER PRIMARY KEY auto_increment,
                                     name VARCHAR(40),
    genre VARCHAR(20),
    synopsis VARCHAR(100),
    releaseDate DATE
    );

CREATE TABLE IF NOT EXISTS ActorMovie (
                                          actor_id INTEGER,
                                          movie_id INTEGER,
                                          PRIMARY KEY (actor_id, movie_id),
    FOREIGN KEY (actor_id) REFERENCES Actor(actor_id),
    FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)
    );
