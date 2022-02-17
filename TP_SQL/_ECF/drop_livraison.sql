--==============================================================
--Nom de la base :                                        
--Nom du fichier : drop_livraison.sql                            
--==============================================================


-- Comportement par d�faut: ne pas sortir en cas d'erreur SQL
WHENEVER SQLERROR continue none


Prompt ****************************************
Prompt SUPPRESSION DES TABLES, VUES , SEQUENCES
Prompt ****************************************
DROP TABLE DetailLivraison cascade constraints;

DROP TABLE LigneCommande cascade constraints;

DROP TABLE Commande cascade constraints;

DROP SEQUENCE seq_livraison;

DROP TABLE Livraison cascade constraints;

DROP TABLE Client cascade constraints;

DROP TABLE Article cascade constraints;

purge recyclebin;

prompt
prompt
prompt
prompt ***********************
prompt Reste-t-il des objets ?
prompt ***********************
select * from cat;
