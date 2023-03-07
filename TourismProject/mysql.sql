use tourism;
desc user;
create database tourism;

SELECT * FROM tourism.hotel;

insert into booking(booking_id, date, passenger_count, room_type, day , tour_userid) values(101 ,'2023-03-01', 2,  'STANDARD', 45, 1000);
insert into booking(booking_id, date, passenger_count, room_type, day ) values(100 ,'2023-03-01', 2,  'STANDARD', 8);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1000, 'Mum', 'mumbai',  "jyoti123@gmail.com", "FEMALE", 'Shiv', 'jyoti@123', "54634654", "MH", 293839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1001, 'chadnichok', 'newDehli',  "seema123@gmail.com", "FEMALE", 'Seema', 'jyoti@123', "99634654", "Delhi", 993839);
insert into payment(payment_id,  mode,  status, tour_bookingid) values(9000,"CARD", "SUCCESS", 100);
insert into place(place_id, district,place_name, state, street, zip, tour_bookingid) values(1, "Mumbai", "Marine line", "MH", "CSMT", 429488, 100);
insert into hotel(hotel_id, district,hotel_desc, hotel_fair, hotel_name, state, street, zip, tour_placeid) values(3, "Dehli","Nice facility","72342", "Devaa", "MH", "CSMT", 489488, 1);
insert into tour_package(package_id , package_amount, package_desc, package_name ) values(1,  40923, "including all place in mumbai", "Mumbai Darsharn");
insert into transport( transport_id , trans_desc, transport_name, vtype) values(1,"a large wheeled vehicle meant to carry many passengers along with the bus driver", "Electrict Bus", "Double-decker bus");

insert into user( city,district,  email, gender, name, password, phone_number, state, zip) values('Mum', 'mumbai',  "sunam123@gmail.com", "FEMALE", 'subam', 'jo@123', "994634654", "MH", 993839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1003 ,'Begulore', 'beglor',  "monali3@gmail.com", "FEMALE", 'monali', 'monali@123', "854634654", "MH", 277839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1004 ,'Mum', 'mumbai',  "suraj23@gmail.com", "MALE", 'Suraj', 'suraj@123', "64634654", "MH", 293839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1005 ,'newDelhi', 'Delhi',  "keertna123@gmail.com", "FEMALE", 'Keertana', 'keer@123', "999634654", "MH", 793839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1006 ,'Mum', 'mumbai',  "aparna123@gmail.com", "FEMALE", 'Aparna', 'aparna@123', "66634654", "MH", 993839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1007 ,'Mum', 'mumbai',  "shivi123@gmail.com", "MALE", 'shivam', 'shiv@123', "944634654", "MH", 493839);
insert into user(User_id, city,district,  email, gender, name, password, phone_number, state, zip) values(1008 ,'Mum', 'mumbai',  "rohini123@gmail.com", "FEMALE", 'Rohini', 'rohini@123', "354634654", "MH", 493839);
insert into place(place_id, district,place_name, state, street, zip, tour_bookingid) values(2, "Delhi", "TajManhal", "DH", "liva street", 929488, 100);

insert into booking(booking_id, date, passenger_count, room_type, day , tour_userid) values(105 ,'2023-03-02', 5,  'STANDARD', 2, 1001);
insert into booking(booking_id, date, passenger_count, room_type, day , tour_userid) values(103 ,'2023-03-04', 3 , 'DELUXE', 4, 1007);
insert into booking(booking_id, date, passenger_count, room_type, day , tour_userid) values(104 ,'2023-03-06', 3,  'DELUXE', 5, 1003);
insert into booking(booking_id, date, passenger_count, room_type, day , tour_userid) values(109 ,'2023-03-11', 1,  'STANDARD', 3, 1004);
