-- Drop tables if they already exist
DROP TABLE IF EXISTS AmenityReservations;
DROP TABLE IF EXISTS Amenities;
DROP TABLE IF EXISTS MaintenanceRequest;
DROP TABLE IF EXISTS Messages;
DROP TABLE IF EXISTS Conversations;
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
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (posted_by) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO announcements (title, content, posted_by) VALUES
                                                          ('Community Event', 'Join us for a community gathering this weekend.', 1),
                                                          ('Maintenance Notice', 'Scheduled maintenance on 2024-12-01.', 2),
                                                          ('Gym Update', 'New equipment has been added to the gym.', 4);

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

INSERT INTO discussions (content, announcement_id, posted_by) VALUES
                                                                  ('Looking forward to the event!', 1, 2),
                                                                  ('Thanks for the notice.', 2, 3),
                                                                  ('The new equipment is great!', 3, 4);

-- Create Conversations Table
CREATE TABLE Conversations
(
    conversation_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    admin_id INT NOT NULL,
    last_message TEXT,
    last_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (admin_id) REFERENCES users(id)
);

INSERT INTO Conversations (user_id, admin_id, last_message) VALUES
                                                                (2, 1, 'Hello, I have a question about the announcement.'),
                                                                (3, 1, 'Can you help with my account?'),
                                                                (4, 1, 'The new equipment is great!');

-- Create Messages Table
CREATE TABLE Messages
(
    message_id INT PRIMARY KEY AUTO_INCREMENT,
    conversation_id INT NOT NULL,
    sender_id INT NOT NULL,
    content TEXT NOT NULL,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (conversation_id) REFERENCES Conversations(conversation_id),
    FOREIGN KEY (sender_id) REFERENCES users(id)
);

INSERT INTO Messages (conversation_id, sender_id, content) VALUES
                                                               (1, 2, 'Hello, I have a question about the announcement.'),
                                                               (2, 3, 'Can you help with my account?'),
                                                               (3, 4, 'The new equipment is great!');

-- Create MaintenanceRequest Table
CREATE TABLE MaintenanceRequest
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    description TEXT NOT NULL,
    request_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO MaintenanceRequest (user_id, description, request_date) VALUES
                                                                        (2, 'Leaking pipe in the kitchen.', '2024-12-01'),
                                                                        (3, 'Heating system not working.', '2024-12-02'),
                                                                        (4, 'Window glass broken.', '2024-12-03');

-- Create Amenities Table
CREATE TABLE Amenities
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    amenity_name VARCHAR(50) NOT NULL,
    image_url VARCHAR(255)
);

INSERT INTO Amenities (amenity_name, image_url) VALUES
                                                    ('Swimming Pool', 'http://example.com/pool.jpg'),
                                                    ('Gym', 'http://example.com/gym.jpg'),
                                                    ('Tennis Court', 'http://example.com/tennis.jpg');

-- Create AmenityReservations Table
CREATE TABLE AmenityReservations
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    amenity_id INT NOT NULL,
    reservation_date DATE NOT NULL,
    reservation_time TIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (amenity_id) REFERENCES Amenities(id)
);

INSERT INTO AmenityReservations (user_id, amenity_id, reservation_date, reservation_time) VALUES
                                                                                              (2, 1, '2024-12-01', '14:00:00'),
                                                                                              (3, 2, '2024-12-02', '10:00:00'),
                                                                                              (4, 3, '2024-12-03', '16:00:00');
