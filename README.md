# MovieMVC
This project involves registering movies and actors, and making the respective assignments between the actors and the movies.

# How to run
1. [Install](https://www.mysql.com/downloads/) MySQL
2. [Download](https://dev.mysql.com/downloads/connector/j/) JDBC driver for MySQL
3. Create the tables in mySQL using the following command:
```markdown
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
)
```

4. Create a 'connection.properties' file with the following details: 
```markdown
db.url=jdbc:mysql://localhost:port/your_database_name
db.user=your_username
db.password=your_password
```