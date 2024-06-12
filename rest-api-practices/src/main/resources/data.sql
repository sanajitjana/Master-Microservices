
--Create Users
insert into user_details(id,name,date_of_birth) values(1001, 'Sanajit Jana', current_date());
insert into user_details(id,name,date_of_birth) values(1002, 'Brajesh Lovanshi', current_date());

--Create posts
insert into post(id,description,user_id) values(2001, 'This is Sanajit-s first post', 1001);
insert into post(id,description,user_id) values(2002, 'This is Sanajit-s second post', 1001);
insert into post(id,description,user_id) values(2003, 'This is Brajesh-s first post', 1002);
insert into post(id,description,user_id) values(2004, 'This is Brajesh-s second post', 1002);