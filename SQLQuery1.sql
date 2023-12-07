CREATE DATABASE Licencia

use Licencia

CREATE TABLE Licencias(
Edad int,
Licencia varchar(50),
Estacion nvarchar(50),
Genero varchar(20),
CalificacionTeorica int,
CalificacionPractica varchar(30),
Aprobacion varchar(4)
)

DELETE Licencias

BULK INSERT
	Licencias
FROM 
	'C:\TEMP\Datos.ARFF'
WITH(
	FIELDTERMINATOR = ',',
	ROWTERMINATOR = '0x0a',
	FIRSTROW = 1
)

SELECT * FROM Licencias