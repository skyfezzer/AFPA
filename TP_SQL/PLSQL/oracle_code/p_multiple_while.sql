CREATE OR REPLACE PROCEDURE MULTIPLE_WHILE(bornem NUMBER,bornep NUMBER)
IS
currentvalue NUMBER;
BEGIN
    DELETE FROM RESULTAT WHERE CODE = 'QUEST-2';
    SELECT BORNEM INTO CURRENTVALUE FROM DUAL;
    WHILE CURRENTVALUE <= BORNEP LOOP
        IF MOD(CURRENTVALUE,3) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-2','multiple de 3 trouv� :',CURRENTVALUE);
        END IF;
        IF MOD(CURRENTVALUE,4) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-2','multiple de 4 trouv� :',CURRENTVALUE);
        END IF;
        IF MOD(CURRENTVALUE,5) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-2','multiple de 5 trouv� :',CURRENTVALUE);
        END IF;
        SELECT CURRENTVALUE + 1 INTO CURRENTVALUE FROM DUAL;
    END LOOP;
END;
/