-- CREATE TABLE myuser (username VARCHAR(32) NOT NULL PRIMARY KEY, password VARCHAR(150) NOT NULL);
-- CREATE TABLE myrole (username VARCHAR(32) NOT NULL, rolename VARCHAR(32) NOT NULL, PRIMARY KEY (username, rolename));
--
-- INSERT INTO myuser(username,password) VALUES('admin','jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
-- INSERT INTO myrole(username,rolename) VALUES('admin','ADMIN');

INSERT INTO flower(name, dateOfPlant, dogToxic) VALUES('Hoja', '2011-12-12', 'false');
INSERT INTO flower(name, dateOfPlant, dogToxic) VALUES('Dracena', '2011-01-13', 'false');
INSERT INTO flower(name, dateOfPlant, dogToxic) VALUES('Fikus', '2009-04-19', 'true');
INSERT INTO flower(name, dateOfPlant, dogToxic) VALUES('Aloes', '2009-04-19', 'true');
--

INSERT INTO person(name,surname) VALUES('Mietek','Kropkowski');
INSERT INTO person(name,surname) VALUES('Pawel','Burkowski');

