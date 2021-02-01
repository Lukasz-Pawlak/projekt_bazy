drop user if exists 'admin'@'localhost';
create user 'admin'@'localhost';
set password for 'admin'@'localhost' = 'admin';
grant select, update, drop, insert on shop.* to 'admin'@'localhost'; -- nwm czy drop też, to niby admin ale no nie wiem

drop user if exists 'employee'@'localhost';
create user 'employee'@'localost';
set password for 'employee'@'localost' = 'employee';
grant select,insert on shop.* to 'employee'@'localhost';

drop user if exists 'manager'@'localhost';
create user 'manager'@'localhost';
set password for 'manager'@'localhost'='manager';
grant select,update,insert on shop.* to 'manager'@'localhost';

GRANT EXECUTE ON PROCEDURE addClient TO 'employee'@'localost';
GRANT EXECUTE ON PROCEDURE addClient TO 'admin'@'localhost';
GRANT EXECUTE ON PROCEDURE addClient TO 'manager'@'localhost';

GRANT EXECUTE ON PROCEDURE addLine TO 'employee'@'localost';
GRANT EXECUTE ON PROCEDURE addLine TO 'admin'@'localost';
GRANT EXECUTE ON PROCEDURE addLine TO 'manager'@'localost';

GRANT EXECUTE ON PROCEDURE addInvoice TO 'employee'@'localost';
GRANT EXECUTE ON PROCEDURE addInvoice TO 'admin'@'localost';
GRANT EXECUTE ON PROCEDURE addInvoice TO 'manager'@'localost';

GRANT EXECUTE ON PROCEDURE addProduct TO 'employee'@'localost';
GRANT EXECUTE ON PROCEDURE addProduct TO 'admin'@'localost';
GRANT EXECUTE ON PROCEDURE addProduct TO 'manager'@'localost';



