use shop;

create user if not exists 'admin1'@'localhost' identified by 'admin';
create user if not exists 'employee1'@'localhost' identified by 'employee';
create user if not exists 'manager1'@'localhost' identified by 'manager';

CREATE ROLE IF NOT EXISTS administrator@'localhost';
CREATE ROLE IF NOT EXISTS employee@'localhost';
CREATE ROLE IF NOT EXISTS manager@'localhost';

grant administartor@'localhost' to 'admin1'@'localhost';
grant manager@'localhost' to 'manager1'@'localhost';
grant employee@'localhost' to 'employee1'@'localhost';

/* tutaj wyrzuca bład */
SET DEFAULT ROLE employee to 'employee'@'localhost';
SET DEFAULT ROLE manager to 'manager1'@'localhost';
SET DEFAULT ROLE administrator TO 'admin1'@'localhost';

GRANT ALL ON shop.* TO admin;
GRANT EXECUTE,INSERT,UPDATE,SELECT ON shop.* TO manager;
GRANT EXECUTE,INSERT,SELECT ON shop.* TO employee;

GRANT EXECUTE ON PROCEDURE addClient TO employee;
GRANT EXECUTE ON PROCEDURE addClient TO administrator;
GRANT EXECUTE ON PROCEDURE addClient TO manager;

GRANT EXECUTE ON PROCEDURE addLine TO employee;
GRANT EXECUTE ON PROCEDURE addLine TO administrator;
GRANT EXECUTE ON PROCEDURE addLine TO manager;

GRANT EXECUTE ON PROCEDURE addInvoice TO employee;
GRANT EXECUTE ON PROCEDURE addInvoice TO administrator;
GRANT EXECUTE ON PROCEDURE addInvoice TO manager;

GRANT EXECUTE ON PROCEDURE addProduct TO employee;
GRANT EXECUTE ON PROCEDURE addProduct TO administrator;
GRANT EXECUTE ON PROCEDURE addProduct TO manager;


GRANT employee TO 'employee'@'localhost';
GRANT manager TO 'manager'@'localhost';
GRANT admin TO 'admin'@'localhost';

