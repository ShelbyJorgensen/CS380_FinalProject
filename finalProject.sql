CREATE DATABASE finalProject;
USE finalProject;

CREATE TABLE users (
	id INT NOT NULL PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
	);

INSERT INTO users
VALUES(1, "user@email.com", "password");
INSERT INTO users
VALUES(2, "admin@absairline.com", "admin");

CREATE TABLE user_flights (
	id INT NOT NULL,
	flight_id INT NOT NULL,
	date DATE NOT NULL,
	destination VARCHAR(50) NOT NULL
	);

CREATE TABLE flights (
	flight_id INT NOT NULL PRIMARY KEY,
	date DATE NOT NULL,
	destination VARCHAR(50) NOT NULL,
	capacity INT NOT NULL
	);

INSERT INTO flights 
VALUES(1, "2023-07-01", "Seattle, WA", 50);
INSERT INTO flights
VALUES(2, "2023-07-03", "Boston, MA", 60);
INSERT INTO flights
VALUES(3, "2023-07-15", "New York, NY", 80);
INSERT INTO flights
VALUES(4, "2023-08-20", "Miami, FL", 60);
INSERT INTO flights
VALUES(5, "2023-08-02", "Austin, TX", 50);
INSERT INTO flights
VALUES(6, "2023-08-02", "Los Angeles, CA", 60);
INSERT INTO flights
VALUES(7, "2023-09-09", "Seattle, WA", 60);
INSERT INTO flights
VALUES(8, "2023-09-19", "Atlanta, GA", 80);
INSERT INTO flights
VALUES(9, "2023-10-20", "Chicago, IL", 60);
INSERT INTO flights
VALUES(10, "2023-12-24", "New York, NY", 80);
