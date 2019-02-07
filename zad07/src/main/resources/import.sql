
INSERT INTO type(name) VALUES('Inne');
INSERT INTO type(name) VALUES('Lisciaste');

INSERT INTO card(description, electronicversion,onpaper) VALUES('Podlewac dwa razy w tygodniu','true','false');
INSERT INTO card(description, electronicversion,onpaper) VALUES('Nie trzymac na sloncu','false','true');


INSERT INTO flower(name, dateOfPlant, dogToxic, caredescription_id,type_id) VALUES('Hoja', '2011-12-12', 'false','1','2');
INSERT INTO flower(name, dateOfPlant, dogToxic, caredescription_id) VALUES('Dracena', '2011-01-13', 'false','2');
INSERT INTO flower(name, dateOfPlant, dogToxic, type_id) VALUES('Fikus', '2009-04-19', 'true','2');
INSERT INTO flower(name, dateOfPlant, dogToxic, type_id) VALUES('Aloes', '2009-04-19', 'true', '1');
--

INSERT INTO person(name,surname) VALUES('Mietek','Kropkowski');
INSERT INTO person(name,surname) VALUES('Pawel','Burkowski');
INSERT INTO person(name,surname) VALUES('Marynia','Burkowska');


INSERT INTO flower_person(flowers_id,persons_id) VALUES('1','1');
INSERT INTO flower_person(flowers_id,persons_id) VALUES('3','2');
INSERT INTO flower_person(flowers_id,persons_id) VALUES('2','3');
INSERT INTO flower_person(flowers_id,persons_id) VALUES('1','3');
INSERT INTO flower_person(flowers_id,persons_id) VALUES('4','3');


