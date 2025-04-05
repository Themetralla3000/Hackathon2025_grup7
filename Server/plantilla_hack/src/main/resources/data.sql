INSERT INTO users (id, full_name, email, password, created_at, updated_at, racha, poblacio)
VALUES (1, 'Jon Doe', 'jon.doe@example.com', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'DefaultPoblacio');

INSERT INTO consum (consum_date, ducha, grifo, lavadora, cisterna, lavaplatos, total, user_id)
VALUES ('2025-04-01', 70, 20, 15, 30, 18, 153, 1),
       ('2025-04-02', 65, 18, 20, 25, 16, 144, 1),
       ('2025-04-03', 80, 22, 10, 28, 17, 157, 1);