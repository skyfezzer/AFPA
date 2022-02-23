SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE insert_continent(p_cod e_continent.continent_no%TYPE, p_nom e_continent.nom%TYPE) IS
resultat NUMBER(3,0);
BEGIN
    SELECT count(*) INTO resultat FROM E_CONTINENT WHERE UPPER(nom)=UPPER(p_nom);
    IF(resultat >= 1) THEN
        DBMS_OUTPUT.PUT_LINE('Ce continent existe déjà.');
    ELSE
        INSERT INTO E_CONTINENT(continent_no,nom) VALUES (p_cod,p_nom);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(p_nom || ' ajouté avec succès.');
    END IF;
END;
/
EXECUTE INSERT_CONTINENT(5,'asia');
DELETE FROM E_CONTINENT WHERE NOM='asia';