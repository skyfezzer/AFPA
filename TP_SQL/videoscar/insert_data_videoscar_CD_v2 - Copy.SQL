INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean-Pierre',' AMERIS');
INSERT INTO CATEGORIE(CATCOD,CATLIB) VALUES (seq_categorie.nextval,'Comedie drame');
INSERT INTO FILM (FILMCOD,CATCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_categorie.currval,seq_realise.currval,'C''est la vie (VHS)',1800,'TER');
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Lucien', 'Jean-Baptiste');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Jacques', 'Dutronc');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Sandrine', 'Bonnaire');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Jacques', 'Spiesser');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'FRANCE',' 3');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'C est pas sorcier (avion, helicoptere)',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'C est pas sorcier vol a voil, dirigeable',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Fran�ois',' DUPEYRON');
INSERT INTO CATEGORIE(CATCOD,CATLIB) VALUES (seq_categorie.nextval,'Drame');
INSERT INTO FILM (FILMCOD,CATCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_categorie.currval,seq_realise.currval,'C''est quoi la vie ? (VHS)',1800,'TER');
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Eric', 'Caravaca');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Jacques', 'Dufilho');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Jean-Pierre', 'Darroussin');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Isabelle', 'Renauld');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Bertarnd',' TAVERNIER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Capitaine Conan (VHS)',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Ca commence aujourd''hui (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Bruno',' NUYTTEN');
INSERT INTO CATEGORIE(CATCOD,CATLIB) VALUES (seq_categorie.nextval,'Biopic');
INSERT INTO FILM (FILMCOD,CATCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_categorie.currval,seq_realise.currval,'Camille Claudel (VHS)',1800,'TER');
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Isabelle', 'Adjani');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Gerard', 'Depardieu');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Laurent', 'Grevill');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Alain', 'Cuny');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Fabien',' ONTENIENTE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Disco',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Camping',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Brillante',' MENDOZA');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Captive',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Nadine',' LABAKI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Caramel',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Ken',' LOACH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Carla''s song (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Olivier',' ASSAYAS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Carlos 1, 2 et 3',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Christopher',' HAMPTON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Carrington (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Walt',' DISNEY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cars',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cherie, j''ai agrandi le bebe (VHS)',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cherie, j''ai retreci les gosses (VHS)',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chicken Little',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Martin',' SCORSESE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Casino (vo) (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'HARVEY',' Comics');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Casper (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Lasse',' HALLSTROM');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Ce cher intrus (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Nancy',' MEYER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Ce que veulent les femmes (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Woody',' ALLEN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Celebrity (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean-Michel',' VERNER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Celibataires ou comment ne pas le rester',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Elie',' CHOURAQUI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Celle que j''aime',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Walt',' DISNEY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cendrillon (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Patrice',' CHEREAU');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Ceux qui m''aiment prendront le train',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Anne',' LE NY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Ceux qui restent',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Cedric',' KLAPISCH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chacun cherche son chat (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Clement','Marty(Bartabas)');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chamane (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'James',' IVORY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chambre avec vue (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Coline',' SERREAU');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chaos (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'John',' KRISH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chapeau melon et bottes de cuir 1',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Tim',' BURTON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Charlie et la Chocolaterie',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Joseph','McGinty Nichol');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Charlie et ses droles de dames (VHS)',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Charlie''s angels',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Eric',' VALLI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chasseur des tenebres, de miel(VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Emir',' KUSTURICA');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chat noir, chat blanc',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Steven',' SODERBERGH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Che - 1ere partie - L''argentin',1800,'TER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Che - 2eme partie - Guerilla',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Stephen',' FREARS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cheri',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Ang',' LEE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chevauchee avec le diable',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Peter',' LORD');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chicken Run (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Civilisation',' et voyage');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chine et Tibet (documentaire) (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Claire',' DENIS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chocolat (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Merzak',' ALLOUACHE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chouchou',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Joel',' SCHUMACHER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Chute libre (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Giuseppe',' TORNATORE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cinema Paradiso (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Rob',' WALKER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Circus (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Matt',' DILLON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'City of Ghosts',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Lodge',' KERRIGAN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Claire Dolan (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Arnaud',' VIARD');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Clara et moi',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Josiane',' BALASKO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cliente',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Mike',' NICHOLS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Closer',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Michael',' APTED');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Coeur de tonnerre (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Andew',' DOMINIK');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'COGAN',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Mickael',' MANN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Collateral',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Raja',' GOSNELL');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'College attitude (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Paul',' HAGGIS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Collision',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Richard',' RUSH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Color of the night (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Michel','Colluci');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Coluche 1 FAUX n�2 (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'MA.RO.KO','Production');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Coluche, ni pour ...',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Bertrand',' BLIER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Combien tu m''aimes ?',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean',' Pierre RAWSON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Comedie d''amour (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Brad',' PEYTON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Comme chiens et chats',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Vincent',' GARENQ');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Comme les autres',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Lisa',' AZUELOS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Comme t''y es belle',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Agnes',' JAOUI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Comme une image',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Seth','GORDON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Comment tuer son boss',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Serge',' BERGLI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Completement Roumanoff ! (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Frederic',' MERMOUD');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Complices',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Robert',' ZEMECKIS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Contact (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Eric',' ROHMER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Conte de printemps (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Franck',' MANCUSO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Contre Enquete',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Marc',' FITOUSSI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Copacabana',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Henry',' SELICK');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Coraline',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Nicolas',' BOUKHRIEF');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cortex',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Roger',' MICHELL');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Coup de foudre � Notting Hill (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Tom',' TYKWER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cours Lola (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Martin',' SCORSESE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Courts metrages et documentaires',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jerry',' BRUCKHEIMER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Coyote Girl',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Scott',' COOPER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Crazy Heart',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Robert',' YOUNG');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Creatures feroces',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Baltasar',' KORMAKUR');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Crime City',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Carl',' FRANKLIN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Crimes et pouvoir',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Walt',' DISNEY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Croc Blanc (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Olivier',' DUCASTEL');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Crustaces et coquillages',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Richard',' ATTENBOROUGH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cry of freedom (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Laurent',' DEBOISE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cuba (documentaire) (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean',' Paul RAPPENEAU');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Cyrano de Bergerac (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Ron',' HOWARD');
INSERT INTO CATEGORIE(CATCOD,CATLIB) VALUES (seq_categorie.nextval,'Thriller');
INSERT INTO FILM (FILMCOD,CATCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_categorie.currval,seq_realise.currval,'Da Vinci Code',1800,'TER');
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Tom', 'Hanks');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Audrey', 'Tautou');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Jean', 'Reno');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Ian', 'McKellen');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Lars',' VON TRIER');
INSERT INTO CATEGORIE(CATCOD,CATLIB) VALUES (seq_categorie.nextval,'Comedie musicale');
INSERT INTO FILM (FILMCOD,CATCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_categorie.currval,seq_realise.currval,'Dancer in the dark (VHS)',1800,'TER');
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Bj�rk', 'Gudmundsdottir' );
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Catherine', 'Deneuve' );
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Peter', 'Stormare' );
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);
INSERT INTO ACTEUR(ACTCOD,ACTNOM,ACTPRE) VALUES(seq_acteur.nextval,'Vladan', 'Kostig');
INSERT INTO JOUER(FILMCOD,ACTCOD) VALUES (seq_film.currval,seq_acteur.currval);


INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'John',' MALKOVICH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dancer Upstairs',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Darren',' ASHTON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dancing Queens',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Louis',' LETERRIER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Danny, the dog',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Bertrand',' TAVERNIER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dans la brume electrique',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Blake',' EDWARDS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dans la peau d''une blonde (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Paul',' HAGGIS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dans la vallee d''Elah',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Spike',' JONZE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dans le peau de John Malkovich',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Chritophe',' HONORE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dans Paris',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Juan Jose','CAMPANELLA');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dans ses yeux',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Kevin',' COSTNER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Danse avec les loups (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jimmy',' LEVY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Danyboom (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Ran',' SHELTON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dark Blue',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Albert',' MAGNOLI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dark Planet',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Christine',' CARRIERE');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Darling',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jacques',' AUDIARD');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'De battre mon coeur s''est arrete',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Fatih',' AKIN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'De l''autre c�te',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'David',' CHARHON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'De l''autre c�te du periph',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Bertrand',' BONELLO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'De la guerre',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jacques',' AUDIARD');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'De rouille et d''os',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Nils','TAVERNIER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'De toutes nos forces',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Kenneth',' BRANAGH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dead again (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Tony',' SCOTT');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dej� vu',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'John',' BOORMAN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Delivrance (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Kathryn',' BIGELOW');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Demineurs',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Mikael',' HAFSTROM');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Derapage',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Akira',' KUROSAWA');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dersou Ouzala (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Barry',' LEVINSON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Des hommes d''influence (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Xavier',' BEAUVOIS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Des hommes et des Dieux',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Michael',' CIMINO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Desesperate hours (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Pierre',' BOUTRON');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Desire Landru',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'James',' WONG');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Destination finale (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Mike',' LEIGH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Deux filles d''aujourd''hui (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean-Jacques',' ANNAUD');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Deux freres',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean',' BECKER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Deux jours � tuer',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Idit',' CBULA');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Deux vies plus une',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Raymond',' DEVOS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Devos au Palais Royal (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Alain',' CHABAT');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Didier (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Bruno',' PODALYDES');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dieu seul me voit (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Walt',' DISNEY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dinosaure (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Volker',' SCHLONDORFF');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Diplomatie',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Dire',' STRAITS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dire Straits on the night (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Emile',' ARDOLINO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dirty dancing (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Emile',' ARDOLINO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dirty dancing II',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jerome',' BONALDI');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dis Jerome (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Claude',' MILLER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dis lui que je l''aime',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Alexandre',' ARCADY');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dis moi oui (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jean-Jacques',' BEINEIX');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Diva (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Roland',' EMMERICH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dix milles - 10 000',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Burr',' STEERS');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dix sept ans encore',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Quentin',' TARANTINO');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Django unchained',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Jan',' KOUNEN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dobermann (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Tom',' SHADYAC');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Docteur Patch (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Lars',' VON TRIER');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dogme 2 - Les idiots (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Nikita',' MIKHALKOV');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Douze',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Nicolas',' WINDING REFN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'DRIVE',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'Ivan',' REITMAN');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dr�les de peres (VHS)',1800,'TER');

INSERT INTO REALISE(REACOD,REAPRE,REANOM) VALUES(seq_realise.nextval,'David',' LYNCH');
INSERT INTO FILM (FILMCOD,REACOD,FILMTIT,FILMAN,FILNAT) VALUES(seq_film.nextval,seq_realise.currval,'Dune (VHS)',1800,'TER');

INSERT INTO K7 (K7COD,FILMCOD,K7PRI,K7DAT) SELECT seq_k7.nextval,FILM.FILMCOD,0.00,to_date('01-01-1800','DD-MM-YYYY') FROM FILM WHERE FILMTIT LIKE '%VHS%';