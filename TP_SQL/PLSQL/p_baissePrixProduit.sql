CREATE OR REPLACE PROCEDURE BaissePrixProduit IS
CURSOR cur_produit IS SELECT PRODUIT_NO, NOM, PRIX_CONSEILLE FROM E_PRODUIT FOR UPDATE OF PRIX_CONSEILLE;
v_pNo E_PRODUIT.PRODUIT_NO%TYPE;
v_pNom E_PRODUIT.NOM%TYPE;
v_pPrix E_PRODUIT.PRIX_CONSEILLE%TYPE;
v_nbRes NUMBER(2);
numero_ex VARCHAR2(3) := 'EX2';
BEGIN
    OPEN cur_produit;
    LOOP FETCH cur_produit INTO v_pNo,v_pNom,v_pPrix;
    EXIT WHEN NOT cur_produit%FOUND;
    SELECT COUNT(*) INTO v_nbRes FROM E_ARTICLE A WHERE A.PRODUIT_NO = v_pNo;
    IF v_nbRes = 0 THEN
        UPDATE E_PRODUIT 
        SET E_PRODUIT.PRIX_CONSEILLE = TRUNC(v_pPrix*0.8,2) 
        WHERE CURRENT OF cur_produit;
        INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) 
        VALUES (numero_ex,v_pNo || ' - ' || v_pNom || ' baisse de 20%',v_pPrix);
    END IF;
    END LOOP;
    CLOSE cur_produit;
END;
/
EXECUTE BaissePrixProduit;