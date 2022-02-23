SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE AUGMENT_EMPLOYE (e_name E_EMP.NOM%TYPE) IS
curr_emp_service E_SERVICE.NOM%TYPE;
curr_emp_sal E_EMP.SALAIRE%TYPE;
augment_service VARCHAR2(6) := 'Ventes';
num_exercice VARCHAR2(3) := 'EX1';
BEGIN
    SELECT S.NOM, E.SALAIRE
        INTO curr_emp_service, curr_emp_sal
        FROM E_EMP E,E_SERVICE S 
        WHERE UPPER(E.nom) = UPPER(e_name) 
        AND S.SERVICE_NO = E.SERVICE_NO;
    IF(UPPER(curr_emp_service) = UPPER(augment_service)) THEN
        UPDATE E_EMP
            SET E_EMP.SALAIRE = E_EMP.SALAIRE + 50
            WHERE UPPER(E_EMP.NOM) = UPPER(e_name);
        dbms_output.put_line('Salaire augmenté.');
    ELSE
        INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) VALUES (num_exercice,(e_name || ' appartient au service ' || curr_emp_service),curr_emp_sal);
        dbms_output.put_line('Salaire NON augmenté.');
    END IF;
END;
/
EXECUTE AUGMENT_EMPLOYE('DUMAS');
EXECUTE AUGMENT_EMPLOYE('ROPBURN');
EXECUTE AUGMENT_EMPLOYE('BIRI');
ROLLBACK;