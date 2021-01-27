use shop;
delimiter $$
drop procedure if exists addProduct $$
create procedure addProduct(in c int, in b int, in cL int, in t int, in n varchar(100))
begin
	if c not in (select id from Colors) then
    signal sqlstate '45000' set message_text="Wrong color";
    end if;
    if b not in (select id from Brands) then
    signal sqlstate '45000' set message_text="Wrong brands";
    end if;
    if cL not in (select id from CoverageLevels) then
    signal sqlstate '45000' set message_text="Wrong coverage Level";
    end if;
    if t not in (select id from Type) then
    signal sqlstate '45000' set message_text="Wrong type";
    end if;
    if n in(select name from Products) then
    signal sqlstate '45000' set message_text="This product already exists";
    end if;
	insert into Products (color,brand,coverageLevel,type)
    values(c,b,cL,t);
end $$
delimiter ;

delimiter $$
drop procedure if exists addClient $$
create procedure addClient(in n varchar(50), in s varchar(50), in a varchar(100))
begin
 if (select name, surname, address from Clients where name=n and surname=s and address=a) is null then
		insert into Clients(name,surname,addres)
	 values (n,s,a);	
 else
	 signal sqlstate '45000' set message_text="Client already exists";
 end if;
end $$
delimiter ;