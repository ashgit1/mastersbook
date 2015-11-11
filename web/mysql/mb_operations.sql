use mb;

select u.email, u.fname, u.lname, u.phone from users u;

select o.orderid, o.orderdate, o.shipaddress, o.totalprice, o.status from orders o;

select b.bookid, b.title , b.authorfname, b.authorlname, b.category, b.description, b.publisher, b.price from books b;

select uo.email, uo.orderid from users_orders uo;

select ob.orderid, ob.bookid from orders_books ob;

-- Total books ordered on the basis of email id. one email id can have multiple orders:

select u.email, o.orderid, b.title, b.authorfname, b.authorlname, b.price 
from users u, orders o, books b, users_orders uo, orders_books ob 
where u.email=uo.email and o.orderid=uo.orderid and o.orderid=ob.orderid and ob.bookid=b.bookid and 
b.bookid in
(
select bookid from orders_books 
where orderid in (select orderid from users_orders where email = 'adoreashish@gmail.com')
)

-- Total books ordered on the basis of orderid. 1 order id can have 1 or multiple books.

select u.email, o.orderid, b.title, b.authorfname, b.authorlname, b.price 
from users u, orders o, books b, users_orders uo, orders_books ob 
where u.email=uo.email and o.orderid=uo.orderid and o.orderid=ob.orderid and ob.bookid=b.bookid and 
b.bookid in
(
select bookid from orders_books 
where orderid = 1001
)

