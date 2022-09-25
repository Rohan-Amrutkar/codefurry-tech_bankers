create table allocation(id INT PRIMARY KEY AUTO_INCREMENT, user_id INT(5) NOT NULL, asset_id INT NOT NULL, FOREIGN KEY(user_id) REFERENCES user(id) ON DELETE CASCADE, FOREIGN KEY(asset_id) REFERENCES asset(id) ON DELETE CASCADE);

create table messages(id INT PRIMARY KEY AUTO_INCREMENT, user_id INT(5) NOT NULL,asset_id INT(5) NOT NULL, message TEXT NOT NULL,added_date DATE NOT NULL, FOREIGN KEY(user_id) REFERENCES user(id) ON DELETE CASCADE, FOREIGN KEY(asset_id) REFERENCES asset(id) ON DELETE CASCADE);

create table asset(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL, type INT NOT NULL, description VARCHAR(120) NOT NULL, date_added DATE NOT NULL ,is_available INT DEFAULT 1, date_allocated DATE, FOREIGN KEY(type) REFERENCES asset_type(id) ON DELETE CASCADE);

create table asset_type(id INT PRIMARY KEY  AUTO_INCREMENT, type VARCHAR(50) NOT NULL, period INT(5) NOT NULL, late_fee INT(5) NOT NULL, days_ban INT(5) NOT NULL);

create table user(id INT(5) PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30) NOT NULL, role_id INT(5) NOT NULL, telephone VARCHAR(12) NOT NULL, email VARCHAR(50) NOT NULL, username VARCHAR(50) UNIQUE NOT NULL, password VARCHAR(20) NOT NULL, FOREIGN KEY(role_id) REFERENCES role(id) ON DELETE RESTRICT);

create table role(id INT(5) PRIMARY KEY AUTO_INCREMENT, role VARCHAR(25) NOT NULL);

