--/*===========================================================*/
--/* Nom de la base :                                          */
--/* Fichier          :                                        */
--/*===========================================================*/
SELECT "nomChien",SUM("nbPoints") AS "SOMME" 
    FROM "GAGNER" 
    INNER JOIN "Chien" ON "GAGNER"."noTatouage" = "Chien"."noTatouage" 
    GROUP BY "Chien"."nomChien" 
    ORDER BY "SOMME" DESC 
    FETCH FIRST 3 ROWS ONLY;
/