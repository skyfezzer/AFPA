SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE AUGMENT_EMPLOYE (e_name E_EMP.NOM%TYPE) IS
curr_emp_service E_SERVICE.NOM%TYPE;
curr_emp_sal E_EMP.SALAIRE%TYPE;
augment_service_50 VARCHAR2(6) := 'Ventes';
augment_service_30 VARCHAR2(12) := 'Opérations';
num_exercice VARCHAR2(3) := 'EX1';
num_exercice2 VARCHAR2(3) := 'EX2';
BEGIN
    SELECT S.NOM, E.SALAIRE
        INTO curr_emp_service, curr_emp_sal
        FROM E_EMP E,E_SERVICE S 
        WHERE UPPER(E.nom) = UPPER(e_name) 
        AND S.SERVICE_NO = E.SERVICE_NO;
    IF(UPPER(curr_emp_service) = UPPER(augment_service_50)) THEN
        UPDATE E_EMP
            SET E_EMP.SALAIRE = E_EMP.SALAIRE + 50
            WHERE UPPER(E_EMP.NOM) = UPPER(e_name);
        dbms_output.put_line('Salaire de ' ||e_name|| ' augmenté de 50.');
    ELSIF(UPPER(curr_emp_service) = UPPER(augment_service_30)) THEN
        UPDATE E_EMP
            SET E_EMP.SALAIRE = E_EMP.SALAIRE + 30
            WHERE UPPER(E_EMP.NOM) = UPPER(e_name);
        INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) VALUES (num_exercice2,(e_name || ' appartient au service ' || curr_emp_service),curr_emp_sal+30);
        dbms_output.put_line('Salaire de ' ||e_name|| ' augmenté de 30.');
    ELSE
        INSERT INTO E_RESULTAT(code,lb_resultat,vl_resultat) VALUES (num_exercice,(e_name || ' appartient au service ' || curr_emp_service),curr_emp_sal);
        dbms_output.put_line('Salaire de ' ||e_name|| ' NON augmenté.');
    END IF;
END;
/
EXECUTE AUGMENT_EMPLOYE('MADURO');
EXECUTE AUGMENT_EMPLOYE('MAGEE');
EXECUTE AUGMENT_EMPLOYE('ROPBURN');
EXECUTE AUGMENT_EMPLOYE('DUMAS');
ROLLBACK;