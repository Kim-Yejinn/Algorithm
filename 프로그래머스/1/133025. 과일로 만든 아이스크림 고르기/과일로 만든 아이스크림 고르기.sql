-- 코드를 입력하세요
# SELECT a.FLAVOR FROM FIRST_HALF a JOIN ICECREAM_INFO b on a.FLAVOR = b.FLAVOR where a.TOTAL_ORDER > 3000 and b.INGREDIENT_TYPE = "fruit_based" ORDER BY a.TOTAL_ORDER desc

# SELECT FLAVOR FROM FIRST_HALF WHERE TOTAL_ORDER > 3000 and FLAVOR in (select FLAVOR FROM ICECREAM_INFO where INGREDIENT_TYPE = "fruit_based") ORDER BY TOTAL_ORDER desc

SELECT a.FLAVOR
FROM FIRST_HALF a JOIN ICECREAM_INFO b ON a.FLAVOR = b.FLAVOR
WHERE a.TOTAL_ORDER > 3000 and b.INGREDIENT_TYPE = "fruit_based"
ORDER BY a.TOTAL_ORDER desc