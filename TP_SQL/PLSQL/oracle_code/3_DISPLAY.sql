SET SERVEROUTPUT ON;
ALTER SESSION SET NLS_LANGUAGE = 'FRENCH';
DECLARE
resultat VARCHAR2(50);
old_resultat VARCHAR2(50);
BEGIN
    DBMS_OUTPUT.PUT_LINE(TRANSLATE_FR(TO_WORD_EN(&val)));
END;