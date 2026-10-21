CREATE DATABASE IF NOT EXISTS Hospital;
USE Hospital;

DROP TABLE IF EXISTS Nurse;

CREATE TABLE Nurse(
    NurseID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Password VARCHAR(100)
);
INSERT INTO Nurse (NurseID,Name,Password)
VALUES
('Jeff','1234'),
('Maximov','1234'),
('Vladimir','1234');

