# DemotecnicaBVC
Demo técnica requerida por la BVC

Projecto DemoBVCUpload
	URLs:
		- Cargue de archivos 
			http://localhost:8080/bvcdemo/api/v1/invoice/upload
		- Visualizacion de archivos ya cargados 
			http://localhost:8080/bvcdemo/api/v1/invoice/{1d}
				[]id corresponde al id regresado en el cargue exitoso.
	URL swagger
		- http://localhost:8080/swagger-ui/index.html


Projecto DemoBVCStatusChange
	URLs:
		- Actualización estado de los registros
			http://localhost:8082/bvcdemo/api/v1/invoice/status/change
	URL swagger
		- http://localhost:8082/swagger-ui/index.html
		
Projecto DemoBVCStatusChange
	URLs:
		- Actualización estado de los registros
			http://localhost:8084/bvcdemo/api/v1/invoice/reports
	URL swagger
		- http://localhost:8084/swagger-ui/index.html
		


Consideraciones Adicionales
=====================================
Aplicaciones Externas adicionales
	- Motor de base de datos PostgressSQL
	- Broker de mensajeria Kafka

Se anexa proyecto SoaoUI para ejecución.
DemoBVC-soapui-project.xml

VIDEO
======================================
https://youtu.be/UlCwbec0EdI
