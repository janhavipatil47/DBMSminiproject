--Farmer Table 
create table farmer (reg_id int primary key,lname char(20),mname char (20), fname char(20), farmer_loc varchar(50),B_date date,Cont_no int ); 
alter table farmer add gender char(1) check (gender in ('M','F'));
alter table farmer alter column Cont_no varchar(10);
select * from farmer;

--Field table 
create table field (field_id int primary key ,Field_area int ,field_loc varchar (50),reg_id int foreign key references farmer );
select * from field;

--Policies table 
create table policies (P_id int primary key ,p_name char(20) ,Crietria varchar(50) ,s_date date ,end_date date ,reg_id int foreign key references farmer);
select * from policies;

--Loan table 
create table loan (Loan_id int primary key ,loan_type char(20) ,Amount money ,issue_date date ,end_date date ,reg_id int foreign key references farmer);
select * from loan;

--Fertilizers table 
create table Fertilizers (ferti_id int primary key ,ferti_name char(20), amount int ,ferti_type char(20),field_id int foreign key references field );
select * from Fertilizers;

--Crops table 
create table crop (crop_name char(20) primary key , field_id int foreign key references field ,yield_obt int );
select * from crop;



-- INSERTING DATA INTO FARMER
insert into farmer values(1000, 'Sharma', 'Amit', 'Rajesh', 'Kisaan Nagar', '1980-05-12', 9876543210,'M');
insert into farmer values(1001, 'Patel', 'Sita', 'Vijay', 'Gau Ghar', '1975-07-24', 8765432109,'F');
insert into farmer values(1002, 'Iyer', 'Raj', 'Kumar', 'Krishi Kshetra', '1990-03-15', 7654321098 ,'M');
insert into farmer values(1003, 'Verma', 'Priya', 'Anil', 'Khet Khand', '1985-11-05', 6543210987 ,'F');
insert into farmer values(1004, 'Bansal', 'Nisha', 'Ramesh', 'Swarna Farms', '1992-06-30', 5432109876,'F');
insert into farmer values(1005, 'Reddy', 'Vijaya', 'Suresh', 'Dhan Kshetra', '1988-02-20', 4321098765 ,'F' );
insert into farmer values(1006, 'Nair', 'Sunil', 'Gita', 'Mitti Mahal', '1982-09-11', 3210987654 ,'M');
insert into farmer values(1007, 'Singh', 'Karan', 'Deepa', 'Paani Gaon', '1981-12-14', 2109876543,'M');
insert into farmer values(1008, 'Mehta', 'Aditi', 'Ajay', 'Chikitsa Khet', '1984-08-08', 1098765432,'F');
insert into farmer values(1009, 'Kumar', 'Neha', 'Pankaj', 'Khet Khushboo', '1995-10-10', 9876543211 ,'F');
insert into farmer values(1010, 'Joshi', 'Mohit', 'Kavita', 'Hara Bhara', '1983-04-25', 8765432102 ,'M');
insert into farmer values(1011, 'Choudhury', 'Sneha', 'Siddharth', 'Kisan Mandal', '1991-01-30', 7654321093 ,'F');
insert into farmer values(1012, 'Bhat', 'Ravi', 'Tara', 'Nadi Farms', '1978-06-18', 6543210984 ,'M');
insert into farmer values(1013, 'Desai', 'Vikram', 'Ananya', 'Khet Safed', '1970-03-30', 5432109875 ,'M');
insert into farmer values(1014, 'Awasthi', 'Rina', 'Vikash', 'Pashu Kshetra', '1993-12-22', 4321098766 ,'F');

-- INSERTING DATA INTO FIELD

insert into field values(2001, 150, 'Anaj Khet', 1000);
insert into field values(2002, 180, 'Dharam Kshetra', 1001);
insert into field values(2003, 220, 'Krishi Udyan', 1002);
insert into field values(2004, 160, 'Sukha Khet', 1003);
insert into field values(2005, 250, 'Shanti Farms', 1004);
insert into field values(2006, 300, 'Mitti Udyan', 1005);
insert into field values(2007, 200, 'Swarna Khet', 1006);
insert into field values(2008, 280, 'Khaas Khet', 1007);
insert into field values(2009, 140, 'Navi Farms', 1008);
insert into field values(2010, 100, 'Khushal Khet', 1009);
insert into field values(2011, 150, 'Anaj Khet', 1000);

-- INSERTING DATA INTO POLICIES

insert into policies values(3001, 'Crop Insurance', 'Covers losses due to natural disasters', '2023-01-01', '2024-01-01', 1000);
insert into policies values(3002, 'Fertilizer Subsidy', 'Subsidy for purchasing fertilizers up to 50% of cost', '2023-02-01', '2024-02-01', 1001);
insert into policies values(3003, 'Loan Interest Waiver', 'Waiver of interest for loans taken for irrigation', '2023-03-01', '2024-03-01', 1002);
insert into policies values(3004, 'Organic Farming Support', 'Support for transitioning to organic farming', '2023-04-01', '2024-04-01', 1003);
insert into policies values(3005, 'Seed Quality Assurance', 'Free quality seeds for the first season', '2023-05-01', '2024-05-01', 1004);
insert into policies values(3006, 'Equipment Rental Program', 'Subsidized rental of farming equipment', '2023-06-01', '2024-06-01', 1005);
insert into policies values(3007, 'Water Conservation Grant', 'Financial assistance for water-saving technologies', '2023-07-01', '2024-07-01', 1006);
insert into policies values(3008, 'Training and Workshops', 'Free training for modern farming techniques', '2023-08-01', '2024-08-01', 1007);

-- INSERTING DATA INTO LOAN

insert into loan values(4001, 'Personal', 10000.00, '2023-01-10', '2024-01-10', 1000);
insert into loan values(4002, 'Agricultural', 15000.00, '2023-02-15', '2024-02-15', 1001);
insert into loan values(4003, 'Business', 20000.00, '2023-03-20', '2024-03-20', 1002);
insert into loan values(4004, 'Home', 25000.00, '2023-04-25', '2024-04-25', 1003);
insert into loan values(4005, 'Vehicle', 30000.00, '2023-05-30', '2024-05-30', 1004);
insert into loan values(4006, 'Education', 35000.00, '2023-06-05', '2024-06-05', 1005);

-- INSERTING DATA INTO FERTILIZERS

insert into fertilizers values(5001, 'Organic Manure', 100, 'Organic', 2001);
insert into fertilizers values(5002, 'Chemical Fertilizer', 200, 'Chemical', 2002);
insert into fertilizers values(5003, 'Bio Fertilizer', 150, 'Organic', 2003);
insert into fertilizers values(5004, 'NPK Fertilizer', 250, 'Chemical', 2004);
insert into fertilizers values(5005, 'Compost', 300, 'Organic', 2005);
insert into fertilizers values(5006, 'Urea', 400, 'Chemical', 2006);
insert into fertilizers values(5007, 'Vermicompost', 350, 'Organic', 2007);
insert into fertilizers values(5008, 'Superphosphate', 450, 'Chemical', 2008);

-- INSERTING DATA INTO CROPS

insert into crop values ('Wheat', 2001, 500);
insert into crop values ('Rice', 2002, 700);
insert into crop values ('Sugarcane', 2003, 600);
insert into crop values ('Cotton', 2004, 800);
insert into crop values ('Pulses', 2005, 550);
insert into crop values ('Barley', 2006, 750);

