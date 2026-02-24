SELECT C.CAR_ID,
       C.CAR_TYPE, 
        C.DAILY_FEE*30*(1-(  SELECT (REPLACE(P.DISCOUNT_RATE,'%',''))/100
                             FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
                             WHERE P.CAR_TYPE =C.CAR_TYPE 
                                AND P.DURATION_TYPE LIKE '30%'
                        ) )  AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
WHERE C.CAR_TYPE IN ('세단','SUV')
  AND  NOT EXISTS ( SELECT 1
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
                    WHERE H.CAR_ID = C.CAR_ID
                    AND START_DATE <'2022-12-01'
                    AND END_DATE>='2022-11-01'
                   )
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC,C.CAR_TYPE, C.CAR_ID DESC