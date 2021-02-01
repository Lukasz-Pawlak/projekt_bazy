use shop;

drop user if exists 'administrator1'@'localhost';
drop user if exists 'employee1'@'localhost';
drop user if exists 'manager1'@'localhost';

create user 'administrator1'@'localhost' identified by 'admin';
create user 'employee1'@'localhost' identified by 'employee';
create user 'manager1'@'localhost' identified by 'manager';

CREATE ROLE IF NOT EXISTS employee;
CREATE ROLE IF NOT EXISTS manager;

grant manager to 'manager1'@'localhost';
grant employee to 'employee1'@'localhost';

/* tutaj wyrzuca bład */
SET DEFAULT ROLE employee to 'employee1'@'localhost';
SET DEFAULT ROLE manager to 'manager1'@'localhost';

-- TRUNCATE TABLE mysql.proxies_priv;
-- FLUSH PRIVILEGES;

GRANT ALL ON shop.* TO 'administrator1'@'localhost';
GRANT EXECUTE,INSERT,UPDATE,SELECT ON shop.* TO manager;
GRANT EXECUTE,INSERT,SELECT ON shop.* TO employee;

GRANT EXECUTE ON PROCEDURE addClient TO employee;
GRANT EXECUTE ON PROCEDURE addClient TO 'administrator1'@'localhost';
GRANT EXECUTE ON PROCEDURE addClient TO manager;

GRANT EXECUTE ON PROCEDURE addLine TO employee;
GRANT EXECUTE ON PROCEDURE addLine TO 'administrator1'@'localhost';
GRANT EXECUTE ON PROCEDURE addLine TO manager;

GRANT EXECUTE ON PROCEDURE addInvoice TO employee;
GRANT EXECUTE ON PROCEDURE addInvoice TO 'administrator1'@'localhost';
GRANT EXECUTE ON PROCEDURE addInvoice TO manager;

GRANT EXECUTE ON PROCEDURE addProduct TO employee;
GRANT EXECUTE ON PROCEDURE addProduct TO 'administrator1'@'localhost';
GRANT EXECUTE ON PROCEDURE addProduct TO manager;

/*
GRANT employee TO 'employee'@'localhost';
GRANT manager TO 'manager'@'localhost';
GRANT administrator TO 'admin'@'localhost';
*/