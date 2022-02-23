CREATE OR REPLACE PROCEDURE totalCdeCommerciaux2 IS
CURSOR cur_emp IS SELECT E_EMP.NOM,SUM(TOTAL) FROM E_EMP INNER JOIN E_COMMANDE ON E_EMP.EMP_NO = E_COMMANDE.EMP_NO group by E_EMP.EMP_NO, E_EMP.NOM;
v_empNom E_EMP.NOM%TYPE;
v_commTotal E_COMMANDE.TOTAL%TYPE;
numero_ex VARCHAR2(3) := 'EX4';
BEGIN
    OPEN cur_emp;
    LOOP
        FETCH cur_emp INTO v_empnom,v_commTotal;
        EXIT WHEN NOT cur_emp%FOUND;
        INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) VALUES (numero_ex,v_empnom || ' totalise',v_commTotal);
    END LOOP;
    CLOSE cur_emp;
END;
/
EXEC totalCdeCommerciaux2;
SELECT * FROM E_RESULTAT;