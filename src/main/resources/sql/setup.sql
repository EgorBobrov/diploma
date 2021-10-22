delete from  user_role;
delete from  role;
delete from  users;

INSERT INTO role (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER');

INSERT INTO users (id, username, password) VALUES
(1, 'admin', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS'),
(3, 'user', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by');

insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(1,3),
(3,3);
