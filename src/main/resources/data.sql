DROP TABLE IF EXISTS billionaires;
DROP TABLE IF EXISTS TEAM;
DROP TABLE IF EXISTS MEMBERS;
DROP TABLE IF EXISTS TEAM_MEMBERS;


CREATE TABLE TEAM (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
);

CREATE TABLE MEMBERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  teamId INT UNIQUE,
  foreign key (teamId) references TEAM(id)

);

CREATE TABLE TEAM_MEMBERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  membersId INT UNIQUE ,
  teamId INT UNIQUE,
  foreign key (membersId) references MEMBERS(id),
  foreign key (teamId) references TEAM(id)

);

INSERT INTO TEAM (name) VALUES
   ('team good'),
   ('team great'),
   ('team awesome');