SET SERVEROUTPUT ON;
DELETE FROM E_RESULTAT;
--=============infoSalaire===============--
CREATE OR REPLACE PROCEDURE INFOSALAIRE IS
CURSOR curs_emp IS
    SELECT EMP.NOM || ' ' || EMP.PRENOM, EMP.SALAIRE
    FROM
    E_EMP EMP;
curr_nom VARCHAR(55);
curr_sal E_EMP.SALAIRE%TYPE;
numero_ex VARCHAR(3) := 'EX1';
BEGIN
    OPEN CURS_EMP;
    LOOP
    FETCH CURS_EMP INTO CURR_NOM,CURR_SAL;
        IF(CURR_SAL > 1500) THEN
            INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) VALUES(numero_ex,curr_nom || ' a un salaire supérieur à ' || 
                CASE WHEN CURR_SAL>2000 THEN '2000' ELSE '1500' END
                ,CURR_SAL);
        END IF;
    EXIT WHEN NOT CURS_EMP%FOUND;
    END LOOP;
END;
/
EXECUTE INFOSALAIRE;
