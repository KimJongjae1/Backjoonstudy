SELECT D.ID,	D.EMAIL,	D.FIRST_NAME,	D.LAST_NAME
FROM DEVELOPERS D
WHERE (D.SKILL_CODE & (SELECT SUM(CODE)
                       FROM SKILLCODES
                       WHERE NAME='C#' OR NAME='Python'
                      ))>0
ORDER BY ID;
                     