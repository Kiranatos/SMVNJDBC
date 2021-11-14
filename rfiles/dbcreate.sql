DROP DATABASE T01;

CREATE DATABASE T01;

USE T01;

CREATE TABLE users (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE teams (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE users_teams (
  user_id INTEGER REFERENCES users (id),
  team_id INTEGER REFERENCES teams (id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, team_id)
);

INSERT INTO users VALUE (DEFAULT, "ivanov");

INSERT INTO teams VALUE (DEFAULT, "teamA");

-- INSERT INTO users_groups VALUE (1, 1);

SELECT u.login, ' in ', g.name
FROM users_teams ug
JOIN users u ON ug.user_id = u.id
JOIN teams g ON ug.team_id = g.id;