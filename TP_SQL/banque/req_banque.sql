--/*===========================================================*/
--/* Nom de la base :                                          */
--/* Fichier          :                                        */
--/*===========================================================*/

-- PARTIE 5
---- 5.1 ----
-------------
SELECT nocompte,solde FROM COMPTE WHERE noclient=10;

---- 5.2 ----
-------------
SELECT client.noclient, compte.nocompte, compte.solde
    FROM compte
    INNER JOIN client ON client.noclient = compte.noclient
    WHERE dateouverture < TO_DATE('10-OCT-1999','DD-MON-YYYY');

---- 5.3 ----
-------------
--ERROR at line 1:
--ORA-00001: unique constraint (BANQUE.SYS_C008259) violated
--Impossible d'insérer car la foreign key bloque l'insertion.

---- 5.4 ----
-------------
DELETE FROM COMPTE
WHERE nocompte=100;
-- 1 row deleted.

-- SQL> 
select * from compte;

--   NOCOMPTE      SOLDE DATEOUVER   NOCLIENT
-- ---------- ---------- --------- ----------
--        200       2000 10-OCT-99         20
--        300       1000 10-OCT-99         10
--        400          5 20-JUL-00         30
--        600         10 15-OCT-00         30

-- SQL>
 rollback;

-- Rollback complete.

-- SQL> 
select * from compte;

--   NOCOMPTE      SOLDE DATEOUVER   NOCLIENT
-- ---------- ---------- --------- ----------
--        100       1000 05-MAY-99         10
--        200       2000 10-OCT-99         20
--        300       1000 10-OCT-99         10
--        400          5 20-JUL-00         30
--        600         10 15-OCT-00         30

---- 5.5 ----
-------------
-- SQL> 
UPDATE COMPTE
         SET solde = solde - 100
         WHERE nocompte = 100;

-- 1 row updated.

-- SQL> 
UPDATE COMPTE
         SET solde = solde + 100
         WHERE nocompte = 300;

-- 1 row updated.

-- SQL> 
SELECT nocompte,solde FROM COMPTE WHERE noclient=10;

--   NOCOMPTE      SOLDE
-- ---------- ----------
--        100        900
--        300       1100

-- SQL> 
ROLLBACK;

-- Rollback complete.

-- SQL> 
SELECT nocompte,solde FROM COMPTE WHERE noclient=10;

--   NOCOMPTE      SOLDE
-- ---------- ----------
--        100       1000
--        300       1000

---- 6 ----
-----------
-- SQL> 
SELECT solde FROM COMPTE WHERE noclient=10;

--      SOLDE
-- ----------
--       1000
--       1000

-- SQL> 
CREATE INDEX idx_compte_noclient ON COMPTE (noclient);

-- Index created.

-- SQL>
 SELECT solde FROM COMPTE WHERE noclient=10;

--      SOLDE
-- ----------
--       1000
--       1000

---- 7 ----
-----------

/