CREATE OR REPLACE FUNCTION to_word_en(pn$nombre IN NUMBER) 
   RETURN VARCHAR2 
AS 
   -- 
   TYPE table_varchar IS TABLE OF VARCHAR2 (255); 

   -- 
   lv$multiples table_varchar  := table_varchar ('', 
                                  ' thousand ', 
                                  ' million ', 
                                  ' billion ', 
                                  ' trillion ', 
                                  ' quadrillion ', 
                                  ' quintillion ', 
                                  ' sextillion ', 
                                  ' septillion ', 
                                  ' octillion ', 
                                  ' nonillion ', 
                                  ' decillion ', 
                                  ' undecillion ', 
                                  ' duodecillion ', 
                                  ' tridecillion ', 
                                  ' quaddecillion ', 
                                  ' quindecillion ', 
                                  ' sexdecillion ', 
                                  ' septdecillion ', 
                                  ' octdecillion ', 
                                  ' nondecillion ', 
                                  ' dedecillion ' 
                                  ); 

   lv$entier           VARCHAR2 (255) := TRUNC (TO_NUMBER (REPLACE (pn$nombre, ' ', ''))); 
   lv$decimales        VARCHAR2 (255) := SUBSTR (pn$nombre - lv$entier, 2); 
   lv$mots_complets    VARCHAR2 (4000); 
   lv$entier_lettres   VARCHAR2 (4000); 
BEGIN 
   -- 
   -- Traitement de la partie décimale 
   -- 
   IF NVL (lv$decimales, 0) != 0 
   THEN 
      FOR i IN 1 .. lv$multiples.COUNT 
      LOOP 
         EXIT WHEN lv$decimales IS NULL; 

         -- 
         IF (SUBSTR (lv$decimales, LENGTH (lv$decimales) - 2, 3) <> 0) 
         THEN 
            lv$mots_complets := 
                  TO_CHAR (TO_DATE (SUBSTR (lv$decimales, 
                                            LENGTH (lv$decimales) - 2, 
                                            3 
                                           ), 
                                    'j' 
                                   ), 
                           'jsp' 
                          ) 
               || lv$multiples (i) 
               || lv$mots_complets; 
         END IF; 

         lv$decimales := SUBSTR (lv$decimales, 1, LENGTH (lv$decimales) - 3); 
      END LOOP; 

      -- Annonce la décimale (remplacer par Euro pour les montants en euros par exemple) 
      lv$mots_complets := ' point ' || lv$mots_complets; 
      
   END IF; 

   -- 
   -- Traitement de la partie entière 
   -- 
   IF NVL (lv$entier, 0) = 0 
   THEN 
      lv$mots_complets := 'zero'; 
   ELSE 
      FOR i IN 1 .. lv$multiples.COUNT 
      LOOP 
         EXIT WHEN lv$entier IS NULL; 

         -- 
         IF (SUBSTR (lv$entier, LENGTH (lv$entier) - 2, 3) <> 0) 
         THEN 
            lv$mots_complets := 
                  TO_CHAR (TO_DATE (SUBSTR (lv$entier, LENGTH (lv$entier) - 2, 
                                            3), 
                                    'j' 
                                   ), 
                           'jsp' 
                          ) 
               || lv$multiples (i) 
               || lv$mots_complets; 
         END IF; 

         lv$entier := SUBSTR (lv$entier, 1, LENGTH (lv$entier) - 3); 
      END LOOP; 
   END IF; 

   RETURN lv$mots_complets; 
END to_word_en; 
/