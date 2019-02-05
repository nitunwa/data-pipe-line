DROP FUNCTION IF EXISTS systemlibraryv1.getCategoryWIthHigestBooks;

DELIMITER $$

CREATE FUNCTION getCategoryWIthHigestBooks(v_edition int) RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
   DECLARE categoryName VARCHAR(255);
  
SELECT category FROM(
 SELECT category, count(bookname) as total from systemlibraryv1.book 
  where edition=v_edition group by category order by count(bookname) desc  ) A limit 1
    INTO categoryName;
     
 
 RETURN (categoryName);
END
 
 
