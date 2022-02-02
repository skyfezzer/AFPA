--/*===========================================================*/
--/* Nom de la base :                                          */
--/* Fichier          :                                        */
--/*===========================================================*/
delete from pret;
delete from compte;
delete from client;


INSERT INTO Client 
 	VALUES(10,'Luc Sansom','Ottawa','(999)999-9999')
/

INSERT INTO Client 
 	VALUES(20,'Dollard Tremblay','Montréal','(888)888-8888');
	
INSERT INTO Client 
 	VALUES(30,'Lin Bô','Montréal','(777)777-7777');
	
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';

INSERT INTO Compte 
 	VALUES(100,1000.0,'5/5/1999',10)
/
INSERT INTO Compte 
 	VALUES(200,2000,'10/10/1999',20)
/
INSERT INTO Compte 
 	VALUES(300,1000,'10/10/1999',10)
/
INSERT INTO Compte 
 	VALUES(400,5,'20/7/2000',30)
/
INSERT INTO Compte 
 	VALUES(600,10,'15/10/2000',30)
/
INSERT INTO Pret 
 	VALUES(1000,10000,'10/6/2000',10,12,10)
/
INSERT INTO Pret 
 	VALUES(2000,20000,'20/7/2000',12,52,30)
/
INSERT INTO Pret 
 	VALUES(3000,5000,'15/8/2000',12,12,10)
/
COMMIT
/