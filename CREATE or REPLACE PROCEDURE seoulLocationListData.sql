-- 프로시저
-- 1. 목록 출력
CREATE or REPLACE PROCEDURE seoulLocationListData(
   pStart number,
   pEnd number,
   pResult OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN pResult FOR
    SELECT no, title, poster, msg, address, hit, num
    FROM (SELECT no, title, poster, msg, address, hit, rownum as num
    FROM (SELECT no, title, poster, msg, address, hit
    FROM seoul_location ORDER BY no ASC))
    WHERE num BETWEEN pStart AND pEnd;
END;
/

CREATE OR REPLACE PROCEDURE seoulLocationDetailData(
    pNo seoul_location.no%TYPE,
    pResult OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN pResult FOR
        SELECT no, title, poster, msg, address, hit
        FROM seoul_location
        WHERE no=pNo;
END;
/

CREATE OR REPLACE PROCEDURE seoulLocationTotalPage(
    pTotal OUT NUMBER
)
IS
BEGIN
    SELECT CEIL(COUNT(*)/20.0) INTO pTotal
    FROM seoul_location;
END;
/



commit;
