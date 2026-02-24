SELECT FLAVOR
FROM FIRST_HALF H
GROUP BY FLAVOR
ORDER BY (TOTAL_ORDER+(SELECT SUM (J.TOTAL_ORDER)
                           FROM JULY J
                           WHERE J.FLAVOR=H.FLAVOR
                          )) DESC
LIMIT 3
