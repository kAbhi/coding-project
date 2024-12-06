INSERT INTO USERS (id, firstname, lastname, email) VALUES (1, 'Abhishek', 'Sharma', 'a1@s.com');
INSERT INTO USERS (id, firstname, lastname, email) VALUES (2, 'Aditi', 'S', 'a2@s.com');

INSERT INTO Availability (user_id, start_time, end_time)
VALUES (1, '2026-12-05 09:00:00', '2026-12-05 12:00:00');

INSERT INTO Availability (user_id, start_time, end_time)
VALUES (1, '2026-12-06 11:00:00', '2026-12-06 12:00:00');

INSERT INTO Availability (user_id, start_time, end_time)
VALUES (1, '2026-12-07 11:00:00', '2026-12-07 12:00:00');


INSERT INTO Availability (user_id, start_time, end_time)
VALUES (2, '2026-12-05 10:00:00', '2026-12-05 13:00:00');

INSERT INTO Availability (user_id, start_time, end_time)
VALUES (2, '2026-12-06 10:00:00', '2026-12-06 13:00:00');

INSERT INTO Availability (user_id, start_time, end_time)
VALUES (2, '2026-12-07 10:00:00', '2026-12-07 13:00:00');