SELECT h.ID, CASE 
            WHEN pr<=0.25 THEN 'LOW' 
            WHEN pr<=0.50 THEN 'MEDIUM' 
            WHEN pr<=0.75 THEN 'HIGH' 
            ELSE 'CRITICAL'
            END AS  COLONY_NAME
FROM (
    SELECT t.ID, PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY) AS pr
    FROM ECOLI_DATA t

    )h
ORDER BY h.ID;