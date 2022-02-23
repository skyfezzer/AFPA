SET SERVEROUTPUT ON;
EXECUTE REFRESH_SEQ_CONTINENT;
CREATE OR REPLACE PROCEDURE insert_continent2(p_nom e_continent.nom%TYPE) IS
resultat NUMBER(3,0);
BEGIN
    REFRESH_SEQ_CONTINENT;
    SELECT count(*) INTO resultat FROM E_CONTINENT WHERE UPPER(nom)=UPPER(p_nom);
    IF(resultat >= 1) THEN
        DBMS_OUTPUT.PUT_LINE('Ce continent existe déjà.');
    ELSE
        INSERT INTO E_CONTINENT(continent_no,nom) VALUES (seq_continent_no.nextval,p_nom);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(p_nom || ' ajouté avec succès.');
    END IF;
END;
/
EXECUTE insert_continent2('asia');
DELETE FROM E_CONTINENT WHERE NOM='asia';