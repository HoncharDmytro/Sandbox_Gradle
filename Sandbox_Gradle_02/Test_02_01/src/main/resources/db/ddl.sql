-- CREATE USER 'username'@'host' IDENTIFIED WITH authentication_plugin BY 'password';
-- plugins: auth_socket, authentication_plugin, leave out - caching_sha2_password
--
-- CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
-- CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
-- ALTER USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
-- GRANT PRIVILEGE ON database.table TO 'username'@'host';
-- GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES,
--                                            RELOAD on *.* TO 'sammy'@'localhost' WITH GRANT OPTION;
-- GRANT ALL PRIVILEGES ON *.* TO 'sammy'@'localhost' WITH GRANT OPTION;
-- FLUSH PRIVILEGES;
-- REVOKE type_of_permission ON database_name.table_name FROM 'username'@'host';
-- SHOW GRANTS FOR 'username'@'host';
-- DROP USER 'username'@'localhost';
-- Fast login: "mysql -u username -p"
-- SELECT user FROM mysql.user;

CREATE USER 'hibernate'@'localhost' IDENTIFIED BY 'hibernate';
CREATE SCHEMA hibernateDB;
GRANT ALL PRIVILEGES ON hibernateDB.* TO 'hibernate'@'localhost';
FLUSH PRIVILEGES;

--
-- SET GLOBAL time_zone = '+3:00';