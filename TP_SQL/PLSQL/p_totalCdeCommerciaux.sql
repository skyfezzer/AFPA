CREATE OR REPLACE PROCEDURE totalCdeCommerciaux IS
CURSOR cur_emp IS SELECT EMP_NO,NOM FROM E_EMP;
v_empno E_EMP.EMP_NO%TYPE;
v_empNom E_EMP.NOM%TYPE;
v_commTotal E_COMMANDE.TOTAL%TYPE;
v_commEmpNo E_COMMANDE.EMP_NO%TYPE;
v_cumulTotal v_commTotal%TYPE;
numero_ex VARCHAR2(3) := 'EX3';
CURSOR cur_com IS SELECT TOTAL,EMP_NO FROM E_COMMANDE;
BEGIN
    OPEN cur_emp;
    LOOP
        v_cumulTotal := 0;
        FETCH cur_EMP INTO v_empno,v_empNom;
        EXIT WHEN NOT cur_emp%FOUND;
        OPEN cur_com;
        LOOP
            FETCH cur_com INTO v_commTotal,v_commEmpNo;
            EXIT WHEN NOT cur_com%FOUND;
            IF v_empNo = v_commEmpNo THEN
                v_cumulTotal := v_cumulTotal + v_commTotal;
            END IF;
        END LOOP;
        CLOSE cur_com;
        IF v_cumulTotal > 0 THEN
            INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) VALUES (numero_ex,v_empNom || ' totalise',v_cumulTotal);
        END IF;
    END LOOP;
    CLOSE cur_emp;
END;
/
EXEC totalCdeCommerciaux;