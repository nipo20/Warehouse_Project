SET DATABASE TO 'testdb';

-- schema
CREATE SCHEMA INVENTORY;

--Insert data into price_inventory table
insert into price_details (product_Id, price_Value) values (12345,299.99);


--Insert data into product_inventory table
insert into product_inventory (product_Id, product_Name,price) values (12345, 'smaland',399.99);
insert into product_inventory (product_Id, product_Name,price) values (123456, 'Åre',1599.99);
insert into product_inventory (product_Id, product_Name,price) values (1234567, 'växjö',699.99);
