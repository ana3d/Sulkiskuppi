CREATE TABLE authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE webuser2 (
  id integer NOT NULL auto_increment PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL,
  firstname varchar(255) default NULL,
  lastname varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE webuser2_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  webuser2_id integer NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (webuser2_id) REFERENCES webuser2(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pelaajat (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE ottelut (
	match_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	player_1_id INTEGER NOT NULL,
	player_2_id INTEGER NOT NULL,
	winner_id INTEGER NOT NULL,
	match_date DATE,
	result VARCHAR(255),
	FOREIGN KEY (player_1_id) REFERENCES pelaajat(id),
	FOREIGN KEY (player_2_id) REFERENCES pelaajat(id),
	FOREIGN KEY (winner_id) REFERENCES pelaajat(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
