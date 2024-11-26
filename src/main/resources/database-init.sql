-- Drop tables if they already exist
DROP TABLE IF EXISTS discussions;
DROP TABLE IF EXISTS announcements;
DROP TABLE IF EXISTS users;

-- Create Users Table
CREATE TABLE users
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role ENUM('RESIDENT', 'ADMIN') NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (username, password, role) VALUES
                                                 ('admin_user', 'password123', 'ADMIN'),
                                                 ('john_doe', 'securepass456', 'RESIDENT'),
                                                 ('jane_doe', 'mypassword789', 'RESIDENT'),
                                                 ('super_admin', 'adminpass', 'ADMIN');


-- Create Announcements Table
CREATE TABLE announcements
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    posted_by INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create Discussions Table
CREATE TABLE discussions
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    announcement_id INT NOT NULL,
    posted_by INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (announcement_id) REFERENCES announcements(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (posted_by) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);
