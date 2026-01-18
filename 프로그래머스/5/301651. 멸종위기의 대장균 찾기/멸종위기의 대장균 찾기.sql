WITH RECURSIVE GEN as(
    SELECT ID, PARENT_ID,1 AS generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT a.ID, a.PARENT_ID, g.generation +1
    FROM ECOLI_DATA a
    JOIN GEN g ON a.PARENT_ID=g.ID

)

SELECT COUNT(*) AS COUNT, generation
FROM GEN g
WHERE NOT EXISTS (SELECT 1
                  FROM ECOLI_DATA a
                  WHERE g.ID = a.PARENT_ID
                 )
GROUP BY g.generation
ORDER BY g.generation;


