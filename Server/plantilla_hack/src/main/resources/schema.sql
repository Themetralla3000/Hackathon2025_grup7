CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    racha INT NOT NULL,
    poblacio VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS consum (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      consum_date DATE NOT NULL,
                                      ducha INT NOT NULL,
                                      grifo INT NOT NULL,
                                      lavadora INT NOT NULL,
                                      cisterna INT NOT NULL,
                                      lavaplatos INT NOT NULL,
                                      total INT NOT NULL,
                                      user_id BIGINT NOT NULL,
                                      FOREIGN KEY (user_id) REFERENCES users(id)
    );