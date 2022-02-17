CREATE OR REPLACE PROCEDURE MULTIPLE_FOR(bornem NUMBER,bornep NUMBER)
IS
currentvalue NUMBER;
BEGIN
    DELETE FROM RESULTAT WHERE CODE = 'QUEST-3';
    FOR i IN bornem .. bornep
    LOOP
        EXIT WHEN CURRENTVALUE >= BORNEP;
        IF MOD(i,3) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-3','multiple de 3 trouv� :',i);
        END IF;
        IF MOD(i,4) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-3','multiple de 4 trouv� :',i);
        END IF;
        IF MOD(i,5) = 0 THEN
            INSERT INTO RESULTAT(code,lb_resultat,vl_resultat) VALUES ('QUEST-3','multiple de 5 trouv� :',i);
        END IF;
    END LOOP;
END;
/