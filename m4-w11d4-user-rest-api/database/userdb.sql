DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id serial,
	name VARCHAR(255) not null,
	username VARCHAR(255) not null UNIQUE,
	email VARCHAR(255) not null,
	CONSTRAINT pk_users_id PRIMARY KEY (id)
);

INSERT INTO users (name, username, email) VALUES ('Joe', 'MastaBlasta', 'joe@techelevator.com');
INSERT INTO users (name, username, email) VALUES ('Jared', 'NightNinja', 'jared@techelevator.com');
INSERT INTO users (name, username, email) VALUES ('Billy', 'LittleTables', 'billy@techelevator.com');
INSERT INTO users (name, username, email) VALUES ('Ishaan', 'LittleLate', 'ishaan@techelevator.com');
INSERT INTO users (name, username, email) VALUES ('Sam', 'MagicGatherer', 'sam@techelevator.com');
