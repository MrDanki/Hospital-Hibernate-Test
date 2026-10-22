USE gestion_sanitaria;

DROP PROCEDURE IF EXISTS PrintNurses;

DELIMITER $$
CREATE PROCEDURE PrintNurses()
BEGIN
	SELECT
		Nurses.ID AS ID,
		Nurses.name AS Nombre,
		Nurses.user AS Usuario,
        Nurses.password AS Contraseña
	FROM Nurses;
END $$
DELIMITER ;

CALL PrintNurses();