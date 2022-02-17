/***************************************************************
Remplissage des tables
MAJ: XH
Oracle9i Release 9.2.0.1.0 - Production
JServer Release 9.2.0.1.0 - Production
***************************************************************/

delete from E_STOCK;

delete from E_ENTREPOT;

delete from E_ARTICLE;

delete from E_COMMANDE;

delete from E_CLIENT;

delete from E_EMP;

delete from E_SERVICE;

delete from E_PRODUIT;

delete from E_IMAGE;

delete from E_TEXTE;

delete from E_TITRE;

delete from E_CONTINENT;

delete from E_RESULTAT;

insert into E_RESULTAT (code, lb_resultat, vl_resultat)
 values (0, 'T54QUE5078693MC1ORLSG4RJPES XBIQ89WK3K9T1BQ4J', 0);

insert into E_CONTINENT (continent_no, nom) values (0, 'EUROPE');
insert into E_CONTINENT (continent_no, nom) values (1, 'ASIE');
insert into E_CONTINENT (continent_no, nom) values (2, 'AMERIQUE');
insert into E_CONTINENT (continent_no, nom) values (3, 'AUSTRALIE');


insert into E_TITRE (titre) values ('CHEF DE PROJET');
insert into E_TITRE (titre) values ('CIO');


insert into E_TEXTE (texte_no, validite, nm_fichier, texte)
 values (0, ' ', '8N317TB0S', '2KGXQRK5GQ5Y Y90CQEM5RNYD6G5U 5KXGE DECA3XBF');

insert into E_IMAGE (image_no, format, validite, nm_fichier)
 values (0, 'Y5', ' ', 'XJT994V45GTBUOID1P6N1K8O1E 0CYY2');

insert into E_PRODUIT (produit_no, image_no, texte_no, nom, description, prix_conseille)
 values (0, 0, 0, 'SVH2K', 'aaaaaaaaaa', 25);
insert into E_PRODUIT (produit_no, image_no, texte_no, nom, description, prix_conseille)
 values (1, 0, 0, 'AZERT', 'bbbbbbbbbb', 128);
insert into E_PRODUIT (produit_no, image_no, texte_no, nom, description, prix_conseille)
 values (2, 0, 0, '12345', 'cccccccccc', 7654);

insert into E_SERVICE (service_no, continent_no, nom) values (0, 0, 'Ventes');
insert into E_SERVICE (service_no, continent_no, nom) values (1, 0, 'Opérations');
insert into E_SERVICE (service_no, continent_no, nom) values (2, 0, 'Stock');



insert into E_EMP (emp_no, superieur_no, service_no, titre, nom, prenom, utilisateur, dt_entree, commentaires, salaire, pct_commission)
 values (0, null, 1, 'CIO', 'DUMAS', 'ALBERT', 'FBT', to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 'JUYNKFGV', 2700, 0);
insert into E_EMP (emp_no, superieur_no, service_no, titre, nom, prenom, utilisateur, dt_entree, commentaires, salaire, pct_commission)
 values (1, 0 , 0, 'CIO', 'ROPBURN', 'PAUL', 'FBT', to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 'JUYNKFGV', 1800, 15);
insert into E_EMP (emp_no, superieur_no, service_no, titre, nom, prenom, utilisateur, dt_entree, commentaires, salaire, pct_commission)
 values (2, 1 , 0, 'CIO', 'BIRI', 'YANIS', 'FBT', to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 'JUYNKFGV', 1300, 20);
insert into E_EMP (emp_no, superieur_no, service_no, titre, nom, prenom, utilisateur, dt_entree, commentaires, salaire, pct_commission)
 values (3, 0 , 2, 'CIO', 'MADURO', 'BRUNO', 'FBT', to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 'JUYNKFGV', 1200, 0);
insert into E_EMP (emp_no, superieur_no, service_no, titre, nom, prenom, utilisateur, dt_entree, commentaires, salaire, pct_commission)
 values (4, 3 , 2, 'CIO', 'MAGEE', 'SAM', 'FBT', to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 'JUYNKFGV', 1000, 0);


insert into E_CLIENT (client_no, continent_no, emp_no, nom, telephone, adresse, ville, departement, pays, cp_postal, solvabilite, commentaires)
 values (0, 0, 1, 'DURAND', '0687654332', '12 Allée du Général De Gaulle', 'Champs sur Marne', '77', 'FRANCE', '77360', 'BON', 'Client fidèle depuis 1950');
insert into E_CLIENT (client_no, continent_no, emp_no, nom, telephone, adresse, ville, departement, pays, cp_postal, solvabilite, commentaires)
 values (1, 0, 2, 'HEBERT', '0123456789', '68 Avenue Parmentier', 'Nogent su Marne', '94', 'FRANCE', '94110', 'MOYEN', 'Date d''anniversaire 19 mai 1950');
insert into E_CLIENT (client_no, continent_no, emp_no, nom, telephone, adresse, ville, departement, pays, cp_postal, solvabilite, commentaires)
 values (2, 0, 2, 'MARTIN', '0698235612', '6 Rue des Lillas', 'Saint Maurice', '94', 'FRANCE', '94760', 'MAUVAISE', 'Client sans commande');


insert into E_COMMANDE (commande_no, client_no, emp_no, dt_commande, dt_livraison, total, nt_paiement, validite)
 values (0, 0, 1, to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 30, '7KB20MMY', ' ');
insert into E_COMMANDE (commande_no, client_no, emp_no, dt_commande, dt_livraison, total, nt_paiement, validite)
 values (1, 0, 1, to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 250, '7KB20MMY', ' ');
insert into E_COMMANDE (commande_no, client_no, emp_no, dt_commande, dt_livraison, total, nt_paiement, validite)
 values (2, 1, 2, to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'), 600, '7KB20MMY', ' ');

insert into E_ARTICLE (commande_no, article_no, produit_no, prix, quantite, qte_livree)
 values (0, 0, 0, 0, 0, 0);

insert into E_ENTREPOT (entrepot_no, superieur_no, continent_no, adresse, ville, departement, pays, cp_postal, telephone)
 values (0, 0, 0, 'HLW3A', 'KXI ', '0A0', 'DD5', '5S9', 'VX3');

insert into E_STOCK (produit_no, entrepot_no, qte_stockee, stock_securite, max_stocke, detail_sortie, dt_stocke)
 values (0, 0, 0, 0, 0, 'XCC0', to_date('02/12/2004 13:46:00', 'DD/MM/YYYY HH24:MI:SS'));


commit;

