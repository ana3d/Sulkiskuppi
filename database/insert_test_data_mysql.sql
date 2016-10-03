-- MUISTA! console encoding latin1

INSERT INTO
	authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');
	

INSERT INTO
	webuser2
VALUES
	(1,'matti','1b320d1d4fca16462b0052e2b465c56d1111f6153670c73409e1d0b7b1f7867ff97fa12c1d465f35',1,'Matti','Meikkis'),
	(2,'aada','7fc74013565cfcf10dd379f964215c866627cdfcf2606ade05323d1273456f6915c2d73cde88e24b',1,'Aada','Admini')
	(3,'sulkis','ed76cc1f4065d274332dfc909b6a6043e3734d2fb86d53ca6d170bd72a588ff82f7658f56c99ec08', 1, 'Sulkis', 'Kuppi');
	
	
INSERT INTO
	webuser2_authority
VALUES
	(1,1,1),
	(2,2,1),
	(3,2,2);
	
-- INSERT INTO webuser2(id, username, password_encrypted,enabled, firstname, lastname) VALUES (3,'sulkis','ed76cc1f4065d274332dfc909b6a6043e3734d2fb86d53ca6d170bd72a588ff82f7658f56c99ec08', 1, 'Sulkis', 'Kuppi');

	
	
INSERT INTO 
	pelaajat(name)
	VALUES
	("Timo"),
	("Jaakko"),
	("Pekka"),
	("Jarmo"),
	("Niina"),
	("Tiina"),
	("Jouko"),
	("Jouni"),
	("Roope");
	
INSERT INTO
	ottelut (player_1_id, player_2_id, winner_id, match_date, result)
	VALUES
	(1,2,1,"2016-10-03", "3-2"),
	(2,3,3,"2016-10-03", "3-9"),
	(3,4,3,"2016-10-03", "6-0"),
	(4,5,4,"2016-10-03", "1-0"),
	(5,6,6,"2016-10-03", "3-7"),
	(6,7,6,"2016-10-03", "3-5"),
	(7,8,7,"2016-10-03", "4-2"),
	(9,1,1,"2016-10-03", "3-4"),
	(1,8,1,"2016-10-03", "1-0"),
	(8,1,1,"2016-10-03", "2-1"),
	(9,2,2,"2016-10-03", "3-2"),
	(7,2,2,"2016-10-03", "1-2"),
	(6,2,6,"2016-10-03", "4-2"),
	(5,2,5,"2016-10-03", "3-2"),
	(4,2,4,"2016-10-03", "3-2"),
	(3,1,1,"2016-10-03", "1-2"),
	(5,2,2,"2016-10-03", "1-2"),
	(9,7,7,"2016-10-03", "3-7"),
	(7,9,9,"2016-10-03", "1-7"),
	(1,9,1,"2016-10-03", "3-2"),
	(4,9,4,"2016-10-03", "3-2"),
	(8,5,5,"2016-10-03", "3-4");
	

