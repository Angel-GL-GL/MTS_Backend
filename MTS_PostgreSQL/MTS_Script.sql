/*Medios de transporte*/
CREATE TABLE transports(
	transport_name VARCHAR(50) NOT NULL,
	transport_speed NUMERIC(4,2) NOT NULL DEFAULT 0.0,
	transport_price INTEGER NOT NULL,
	CONSTRAINT pk_transport PRIMARY KEY(transport_name)
);

/*Lineas*/
CREATE TABLE lines(
	line_id SERIAL NOT NULL,
	line_name VARCHAR(2) NOT NULL,
	line_transport VARCHAR(50) NOT NULL,
	line_incident VARCHAR(1000) DEFAULT '-',
	line_information VARCHAR(1000) DEFAULT '-',
	line_speed NUMERIC(4,2) NOT NULL DEFAULT 0.0,
	CONSTRAINT pk_line PRIMARY KEY(line_id),
	CONSTRAINT fk_lines_transports FOREIGN KEY(line_transport)
		REFERENCES transports(transport_name) ON UPDATE CASCADE
);

/*Estaciones*/
CREATE TABLE stations(
	station_id SERIAL NOT NULL,
	station_name VARCHAR(75) NOT NULL,
	station_line INTEGER NOT NULL,
	station_incident VARCHAR(1000) DEFAULT '-',
	station_information VARCHAR(1000) DEFAULT '-',
	station_coord_x NUMERIC(12,6) NOT NULL,
	station_coord_y NUMERIC(12,6) NOT NULL,
	station_radius NUMERIC(12,6) NOT NULL,
	CONSTRAINT pk_station PRIMARY KEY(station_id),
	CONSTRAINT fk_stations_lines FOREIGN KEY(station_line)
		REFERENCES lines(line_id) ON UPDATE CASCADE
);

/*Transbordos*/
CREATE TABLE transfers(
	transfer_id SERIAL NOT NULL,
	transfer_station_a INTEGER NOT NULL,
	transfer_station_b INTEGER NOT NULL,
	transfer_distance NUMERIC(3,6) NOT NULL DEFAULT 0.0,
	CONSTRAINT pk_transfer PRIMARY KEY(transfer_id),
	CONSTRAINT fk_transfers_stations_a FOREIGN KEY(transfer_station_a)
		REFERENCES stations(station_id) ON UPDATE CASCADE,
	CONSTRAINT fk_transfers_stations_b FOREIGN KEY(transfer_station_b)
		REFERENCES stations(station_id) ON UPDATE CASCADE
);

/*Usuarios*/
CREATE TABLE users(
	user_id SERIAL NOT NULL,
	user_name VARCHAR(50) NOT NULL,
	user_lastname_pat VARCHAR(50) NOT NULL,
	user_lastname_mat VARCHAR(50) NOT NULL DEFAULT '-',
	user_email VARCHAR(50) NOT NULL,
	user_curp VARCHAR(18) NOT NULL,
	user_ocupation VARCHAR(50) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_phone VARCHAR(10) NOT NULL DEFAULT '0000000000',
	CONSTRAINT pk_user PRIMARY KEY(user_id)
);

/*Administradores*/
CREATE TABLE administrators(
	admin_id varchar(10) NOT NULL,
	admin_user INTEGER NOT NULL,
	admin_transport VARCHAR(50) NOT NULL,
	CONSTRAINT pk_administrator PRIMARY KEY(admin_id),
	CONSTRAINT fk_administrators_users FOREIGN KEY(admin_user)
		REFERENCES users(user_id) ON UPDATE CASCADE,
	CONSTRAINT fk_administrators_transports FOREIGN KEY(admin_transport)
		REFERENCES transports(transport_name) ON UPDATE CASCADE
);

/*Supervisores*/
CREATE TABLE supervisors(
	supervisor_id varchar(10) NOT NULL,
	supervisor_user INTEGER NOT NULL,
	supervisor_admin varchar(10) NOT NULL,
	supervisor_line INTEGER NOT NULL,
	supervisor_station INTEGER NOT NULL,
	CONSTRAINT pk_supervisor PRIMARY KEY(supervisor_id),
	CONSTRAINT fk_supervisors_users FOREIGN KEY(supervisor_user)
		REFERENCES users(user_id) ON UPDATE CASCADE,
	CONSTRAINT fk_supervisors_administrators FOREIGN KEY(supervisor_admin)
		REFERENCES administrators(admin_id) ON UPDATE CASCADE,
	CONSTRAINT fk_supervisors_lines FOREIGN KEY(supervisor_line)
		REFERENCES lines(line_id) ON UPDATE CASCADE,
	CONSTRAINT fk_supervisors_stations FOREIGN KEY(supervisor_station)
		REFERENCES stations(station_id) ON UPDATE CASCADE
);

/*Comentarios*/
CREATE TABLE opinions(
	opinion_id SERIAL NOT NULL,
	opinion_user INTEGER NOT NULL,
	opinion_station INTEGER NOT NULL,
	opinion_date DATE NOT NULL DEFAULT CURRENT_DATE,
	opinion_time TIME NOT NULL DEFAULT CURRENT_TIME,
	opinion_body VARCHAR(1000) NOT NULL,
	opinion_type VARCHAR(10) NOT NULL,
	CONSTRAINT pk_opinion PRIMARY KEY(opinion_id),
	CONSTRAINT fk_opinions_users FOREIGN KEY(opinion_user)
		REFERENCES users(user_id) ON UPDATE CASCADE,
	CONSTRAINT fk_opinions_stations FOREIGN KEY(opinion_station)
		REFERENCES stations(station_id) ON UPDATE CASCADE
);

/*Reportes*/
CREATE TABLE reports(
	report_id SERIAL NOT NULL,
	report_user INTEGER NOT NULL,
	report_transport VARCHAR(50) NOT NULL,
	report_line INTEGER NOT NULL,
	report_station INTEGER NOT NULL,
	report_date DATE NOT NULL DEFAULT CURRENT_DATE,
	report_time TIME NOT NULL DEFAULT CURRENT_TIME,
	report_body VARCHAR(1000) NOT NULL,
	report_status VARCHAR(11) NOT NULL DEFAULT 'Sin validar',
	CONSTRAINT pk_report PRIMARY KEY(report_id),
	CONSTRAINT fk_reports_users FOREIGN KEY(report_user)
		REFERENCES users(user_id) ON UPDATE CASCADE,
	CONSTRAINT fk_reports_transports FOREIGN KEY(report_transport)
		REFERENCES transports(transport_name) ON UPDATE CASCADE,
	CONSTRAINT fk_reports_lines FOREIGN KEY(report_line)
		REFERENCES lines(line_id) ON UPDATE CASCADE,
	CONSTRAINT fk_reports_stations FOREIGN KEY(report_station)
		REFERENCES stations(station_id) ON UPDATE CASCADE
);

/*Evidencias*/
CREATE TABLE evidences(
	evidence_id SERIAL NOT NULL,
	evidence_creation_date DATE NOT NULL DEFAULT CURRENT_DATE,
	evidence_creation_time TIME NOT NULL DEFAULT CURRENT_TIME,
	evidence_shipment_date DATE NOT NULL DEFAULT CURRENT_DATE,
	evidence_shipment_time TIME NOT NULL DEFAULT CURRENT_TIME,
	evidence_body VARCHAR(1000) NOT NULL,
	CONSTRAINT pk_evidence PRIMARY KEY(evidence_id)
);

/*Match de reportes con su evidencia*/
CREATE TABLE reports_evidences_match(
	rem_id SERIAL NOT NULL,
	rem_report INTEGER NOT NULL,
	rem_evidence INTEGER NOT NULL,
	rem_supervisor varchar(10) NOT NULL,
	CONSTRAINT pk_rem PRIMARY KEY(rem_id),
	CONSTRAINT fk_rem_reports FOREIGN KEY(rem_report)
		REFERENCES reports(report_id) ON UPDATE CASCADE,
	CONSTRAINT fk_rem_evidences FOREIGN KEY(rem_evidence)
		REFERENCES evidences(evidence_id) ON UPDATE CASCADE,
	CONSTRAINT fk_rem_supervisors FOREIGN KEY(rem_supervisor)
		REFERENCES supervisors(supervisor_id) ON UPDATE CASCADE
);

INSERT INTO users(
	user_name,user_lastname_pat,user_lastname_mat,user_email,
	user_curp,user_ocupation,user_password,user_phone
	) VALUES
	('Juan','Angeles','Santos','jpas@gmail.com',
	'ansj020121hdfuplp7','estudiante','superju4np','5502020101'),
	('Sebastian',	'Espinosa',	'Sanchez','ises@gmail.com',
	'essi010921hdfpupl6','estudiante','sebastitianan','5503030303'),
	('Andres','Guzman','Cruz','amgc@gmail.com',
	'guca020815hdfvtal5','estudiante','andr3sGuzguz','5500020200');

INSERT INTO transports(transport_name,transport_speed,transport_price)
	VALUES ('STC',10.0,5);

INSERT INTO lines(line_name,line_transport,line_speed)
	VALUES('1','STC',10.0);

INSERT INTO stations(station_name,station_line,
	station_coord_x,station_coord_y,station_radius)
	VALUES('Observatorio','1',10.0,10.0,1.0),('Tacubaya','1',15.0,15.0,1.0),
	('Juanacatlan','1',20.0,20.0,1.0);

INSERT INTO administrators(admin_id,admin_user,admin_transport) 
	VALUES('0000000000',4,'STC');

INSERT INTO supervisors(supervisor_id,supervisor_user,supervisor_admin,supervisor_line,supervisor_station) 
	VALUES('1111111111',2,'0000000000',1,1),('2222222222',3,'0000000000',1,2);

select * from users;
