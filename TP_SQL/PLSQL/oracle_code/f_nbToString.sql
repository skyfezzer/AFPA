create or replace FUNCTION nbToString(pn$nombre IN NUMBER) 
   RETURN VARCHAR2 
AS 
BEGIN
    RETURN translate_fr(to_word_en(pn$nombre));
END;
/