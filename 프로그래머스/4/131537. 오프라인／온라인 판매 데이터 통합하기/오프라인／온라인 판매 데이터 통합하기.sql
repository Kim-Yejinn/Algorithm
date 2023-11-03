-- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 
FROM ONLINE_SALE
WHERE SALES_DATE between "2022-03-01" and "2022-03-31"

UNION ALL

SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, NULL USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE between "2022-03-01" and "2022-03-31"

ORDER BY SALES_DATE, PRODUCT_ID, USER_ID