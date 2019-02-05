DROP PROCEDURE IF EXISTS systemlibraryv1.GetCatergory;



DELIMITER $$
CREATE PROCEDURE GetCatergory ( IN  bookCatagory VARCHAR(255), OUT total int )
BEGIN
SELECT  count(bookname) INTO total from systemlibraryv1.book 
WHERE  category = bookCatagory;

END

Call systemlibraryv1.GetCatergory('N-Fiction', @total);
SELECT @total;
