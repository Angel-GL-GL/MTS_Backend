# MTS_Backend
 APIs and PostgreSQL Script

## Stack and libraries 
- Spring Boot
  - `org.springframework.boot`
  - `version 3.2.1`
- Java
  - `java`
  - `version 21`
- Maven
  - `mvn`
  - `version 4.0.0`
- SQL DataBase Connection
  - `postgresql`
  - `org.postgresql`
- Building tools
  - `org.projectlombok`

## How to Start
Verify that you have the required java version installed.
```shell
java -version
```

Verify that you have the required maven version installed.
```shell
mvn -version
```

In case you do not have any of the above mentioned, please make the process of indicated in their respective official pages.

It is also necessary that you have a DBMS, the project is configured to be used with `postgresql` but it can be modified. Run you database.

Open the application.properties file and edit the following according to the settings you already have.

Specify the port used to access from the browser
```shell
server.port=8080
```

Specify the dialect of the database that Spring Boot should use
```shell
spring.jpa.database=POSTGRESQL
```

Specify database platform
```shell
spring.datasource.platform=postgres
```

Specify the database port and database name
```shell
spring.datasource.url=jdbc:postgresql://localhost:dbport/name
```

Specify the database username and password
```shell
spring.datasource.username=username
spring.datasource.password=password
```

Specify the dialect that Hibernate will use to generate SQL compatible with your database
```shell
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
```

Navigate to the root of the project via the command line and execute the command
```shell
mvn spring-boot:run
```

Open your browser and access the port you specified in the application.properties file.

## Endpoints Users and Supervisors API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
api/sign-up | POST | Create an user account.
api/sign-in | POST | Login into your login account.
api/update/profile | PUT | Update user information.
api/userByEmail/{email} | GET | Get user information by email.
api/delete | DELETE | Delete user account.
api/supervisor/sign-up | POST | Create a supervisor account.
api/supervisor/sign-in | POST | Login into your supervisor account.
api/supervisor/update/profile | PUT | Update supervisor information.
api/supervisor/delete/profile | DELETE | Delete supervisor account.
api/administrator/sign-in | POST | Login into your administrator account.

### Structure of api/sign-up 
```shell
{
    "name": "***",
    "lastname_pat": "***",
    "lastname_mat": "***",
    "email": "***",
    "curp": "******************",
    "ocuparion": "***",
    "password": "***",
    "phone": "**********"
}
```

### Structure of api/sign-in
```shell
{
    "email": "***",
    "password": "***"
}
```

### Structure of api/update/profile
```shell
{
    "id":0
    "name": "***",
    "lastname_pat": "***",
    "lastname_mat": "***",
    "email": "***",
    "curp": "******************",
    "ocuparion": "***",
    "password": "***",
    "phone": "**********"
}
```

### Structure of api/delete
```shell
{
    "email": "***",
    "password": "***"
}
```

### How to create a supervisor account
- GET request to api/userByEmail/{email}.
- Save the id field.
- POST request to api/supervisor/sign-up, user field has to store the value from id field from the received json.
```shell
{
    "sup": "**********",
    "user": 0,
    "admin": "**********",
    "line": 0,
    "station": 0
}
```

### How to login into a supervisor account
- POST request to api/supervisor/sign-in. The structure of the json is:
```shell
{
    "id": "**********",
    "password": "***"
}
```

### Structure of api/supervisor/update/profile
```shell
{
    "sup": "**********",
    "user": 0,
    "admin": "**********",
    "line": 0,
    "station": 0
}
```

### Structure of api/supervisor/delete
```shell
{
    "id": "**********",
    "password": "***"
}
```

### How to login into a administrator account
- POST request to api/administrator/sign-in. The structure of the json is:
```shell
{
    "id": "**********",
    "password": "***"
}
```

## Endpoints Lines and Stations API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
api/transports | GET | Get all transports.
api/lines | GET | Get all the lines.
api/lines/{line} | GET | Get a line by Id.
api/lines/speeds | GET | Get all lines with speed > 0.
api/transports/lines | GET | Get all lines of the transport.
api/lines/incidents/{in} | GET | Get all the lines that have the incident.
api/lines/update/incident | PUT | Update the incident of the line.
api/routes | GET | Get all routes.
api/routes/{route} | GET | Get a route by Id.
api/lines/{line}/routes | GET | Get all the routes of a line.
api/stations | GET | Get all the stations.
api/stations/{station} | GET | Get a station by Id.
api/lines/{line}/stations | GET | Get all stations of a line.
api/routes/{route}/stations | GET | Get all stations of a route.
api/stations/incidents/{in} | GET | Get all the stations that have the incident.
api/stations/update/incident | PUT | Update the incident of the station.
api/stations/{station}/transfers | GET | Get all transfers of a station.
api/routes/{route}/transfers | GET | Get all the transfers of a route.
api/stations/{station}/schedules | GET | Get all the schedules of the station.
api/routes/{route}/schedules | GET | Get all the schedules of the route.

### Structure of api/lines/update/incident
```shell
{
    "id": 0,
    "incident":"****************",
    "speed": 0.0
}
```

### Structure of api/stations/update/incident
```shell
{
    "id": 0,
    "incident":"****************"
}
```

## Endpoints Reports API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/ | _ | .

## Endpoints Evidences API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/ | _ | .
