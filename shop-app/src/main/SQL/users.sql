use shop;

create user if not exists 'admin'@'localhost' identified by 'admin';
create user if not exists 'employee'@'localost' identified by 'employee';
create user if not exists 'manager'@'localhost' identified by 'manager';

CREATE ROLE IF NOT EXISTS administrator;
CREATE ROLE IF NOT EXISTS employee;
CREATE ROLE IF NOT EXISTS manager;
/* tutaj wyrzuca bład */
GRANT employee TO 'employee'@'localost';
GRANT manager TO 'manager'@'localhost';
GRANT admin TO 'admin'@'localhost';

SET DEFAULT ROLE employee TO 'employee'@'localost';
SET DEFAULT ROLE manager TO 'manager'@'localost';
SET DEFAULT ROLE admin TO 'admin'@'localost';

GRANT ALL ON shop.* TO admin;
GRANT EXECUTE,INSERT,UPDATE,SELECT ON shop.* TO manager;
GRANT EXECUTE,INSERT,SELECT ON shop.* TO employee;

GRANT EXECUTE ON PROCEDURE addClient TO employee;
GRANT EXECUTE ON PROCEDURE addClient TO admin;
GRANT EXECUTE ON PROCEDURE addClient TO manager;

GRANT EXECUTE ON PROCEDURE addLine TO employee;
GRANT EXECUTE ON PROCEDURE addLine TO admin;
GRANT EXECUTE ON PROCEDURE addLine TO manager;

GRANT EXECUTE ON PROCEDURE addInvoice TO employee;
GRANT EXECUTE ON PROCEDURE addInvoice TO admin;
GRANT EXECUTE ON PROCEDURE addInvoice TO manager;

GRANT EXECUTE ON PROCEDURE addProduct TO employee;
GRANT EXECUTE ON PROCEDURE addProduct TO admin;
GRANT EXECUTE ON PROCEDURE addProduct TO manager;



