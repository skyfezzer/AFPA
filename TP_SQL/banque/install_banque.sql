--/***************************************************************
--Script install_banque.sql
--***************************************************************/

-- Comportement recherch�: sortir en cas d'erreur SQL
WHENEVER SQLERROR exit rollback

CREATE TABLE Client
(noClient		INTEGER PRIMARY KEY,
 nomClient 		VARCHAR(18),
 adresseClient		VARCHAR(20),
 noTelephone 		VARCHAR(15)
);
 
CREATE TABLE Compte
(noCompte 		INTEGER PRIMARY KEY,
 solde	 		DECIMAL(10,2) CHECK (solde >= 0),
 dateOuverture 		DATE,
 noClient		INTEGER REFERENCES Client
);
 
CREATE TABLE Pret
(noPret 			INTEGER PRIMARY KEY,
 montantPret 		DECIMAL(10,2),
 dateDebut 		DATE,
 tauxInteret		DECIMAL(8,2),
 frequencePaiement	INTEGER,
 noClient		INTEGER REFERENCES Client
);

--*******************************************
--
--  Divers requ�tes d'interrogation du dictionnaire
--
--*******************************************
SELECT TABLE_NAME 
FROM USER_TABLES;

SELECT COLUMN_NAME
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME='CLIENT'; --identique �:DESCRIBE CLIENT

SELECT TABLESPACE_NAME, EXTENTS, BLOCKS
FROM  USER_SEGMENTS
WHERE SEGMENT_NAME = 'CLIENT';

--Select username from user_users;--equivalent �: select user from dual;
--Select username from dba_users;


prompt
prompt
prompt
Prompt ******************************
prompt INTERROGATION DU DICTIONNAIRE
prompt Recapitulatif des Objets cr��s
Prompt ******************************
select * from user_catalog;
prompt
prompt
prompt
prompt ************************************
prompt    INTERROGATION DU DICTIONNAIRE
prompt Recapitulatif des contraintes pos�es
prompt ************************************

column constraint_name format A20
column type format A3
column table_name format A15
column SEARCH_CONDITION format A30

break on type skip
compute count of constraint_name on type report
select  constraint_name, Constraint_type as type,
        table_name , SEARCH_CONDITION, DELETE_RULE, STATUS
from user_constraints
order by type, table_name;


clear columns
clear breaks
clear computes
