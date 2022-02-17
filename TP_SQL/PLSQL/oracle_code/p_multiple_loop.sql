CREATE TABLE RESULTAT(code VARCHAR2(15),lb_resultat VARCHAR2(55), vl_resultat INTEGER);
CREATE OR REPLACE PROCEDURE MULTIPLE_LOOP(bornem NUMBER,bornep NUMBER)
IS
currentvalue NUMBER;
BEGIN
    DELETE FROM RESULTAT WHERE CODE = 'QUEST-1';
    --FOR i IN bornem .. bornep
    SELECT BORNEM INTO CURRENTVALUE FROM DUAL;
    LOOP
        EXIT WHEN CURRENTVALUE > BORNEP;
        IF MOD(CURRENTVALUE,3) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-1','multiple de 3 trouv� :',CURRENTVALUE);
        END IF;
        IF MOD(CURRENTVALUE,4) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-1','multiple de 4 trouv� :',CURRENTVALUE);
        END IF;
        IF MOD(CURRENTVALUE,5) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-1','multiple de 5 trouv� :',CURRENTVALUE);
        END IF;
        SELECT CURRENTVALUE + 1 INTO CURRENTVALUE FROM DUAL;
    END LOOP;
END;
/