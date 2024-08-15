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
api/sign-up | POST | Creates a user account.
api/sign-in | POST | Logs into a user account.
api/update/profile | PUT | Updates user information.
api/userByEmail/{email} | GET | Retrieves user information by email.
api/delete | DELETE | Deletes user account.
api/supervisor/sign-up | POST | Creates a supervisor account.
api/supervisor/sign-in | POST | Logs into a supervisor account.
api/supervisor/update/profile | PUT | Updates supervisor information.
api/supervisor/delete/profile | DELETE | Deletes supervisor account.
api/administrator/sign-in | POST | Logs into an administrator account.

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
api/transports | GET | Retrieves all transports.
api/lines | GET | Retrieves all the lines.
api/lines/{line} | GET | Retrieves a line by ID.
api/lines/speeds | GET | Retrieves all lines with speed > 0.
api/transports/lines | POST | Retrieves all lines of a transport.
api/lines/incidents/{in} | GET | Retrieves all lines with the incident.
api/lines/update/incident | PUT | Updates the incident of the line.
api/routes | GET | Retrieves all routes.
api/routes/{route} | GET | Retrieves a route by ID.
api/lines/{line}/routes | GET | Retrieves all the routes of a line.
api/stations | GET | Retrieves all the stations.
api/stations/{station} | GET | Retrieves a station by ID.
api/lines/{line}/stations | GET | Retrieves all stations of a line.
api/routes/{route}/stations | GET | Retrieves all stations of a route.
api/stations/incidents/{in} | GET | Retrieves all stations with the incident.
api/stations/update/incident | PUT | Updates the incident of the station.
api/stations/{station}/transfers | GET | Retrieves all transfers of a station.
api/routes/{route}/transfers | GET | Retrieves all the transfers of a route.
api/stations/{station}/schedules | GET | Retrieves all the schedules of the station.
api/routes/{route}/schedules | GET | Retrieves all the schedules of the route.

### Structure of api/lines/update/incident
```shell
{
    "name": ""
}
```

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
api/reports | GET | Retrieves all reports.
api/reports/register | POST | Creates a report.
api/reports/update/status | PUT | Updates the status of a report.
api/reports/{report} | GET | Retrieves a report by ID.
api/transports/reports | POST | Retrieves all reports of a transport.
api/lines/{line}/reports | GET | Retrieves all reports of a line.
api/routes/{route}/reports | GET | Retrieves all reports of a route.
api/stations/{station}/reports | GET | Retrieves all reports of a station.
api/user/{user}/reports | GET | Retrieves all reports submitted by a user.
api/reports/date | POST | Retrieves all reports on a given date.
api/reports/status/{status} | GET | Retrieves all reports with a given status.
api/transports/reports/search | POST | Retrieves all the reports of a transport on a given date.
api/lines/{line}/reports/search | POST | Retrieves all the reports of a line on a given date.
api/routes/{route}/reports/search | POST | Retrieves all the reports of a route on a given date.
api/stations/{station}/reports/search | POST | Retrieves all the reports of a station on a given date.
api/user/{user}/reports/search | POST | Retrieves all the reports of a user on a given date.

### Structure of api/reports/register
```shell
{
        "user": 0,
        "transport": "",
        "line": 0,
        "route": 0,
        "station": 0,
        "date": "YYYY-MM-DD",
        "time": "HH:MM:SS",
        "body": "",
        "status": "Sin_Validar"
}
```

### Structure of api/reports/update/status
```shell
{
        "id": 0,
        "status": "Validado"
}
```

### Structure of api/transports/reports
```shell
{
        "transport": ""
}
```

### Structure of api/reports/date
```shell
{
        "date": "YYYY-MM-DD"
}
```

### Structure of api/transports/reports/search
```shell
{
        "transport": "",
        "date": "YYYY-MM-DD"
}
```

### Structure of api/lines/{line}/reports/search
```shell
{
        "date": "YYYY-MM-DD"
}
```

### Structure of api/routes/{route}/reports/search
```shell
{
        "date": "YYYY-MM-DD"
}
```

### Structure of api/stations/{station}/reports/search
```shell
{
        "date": "YYYY-MM-DD"
}
```

### Structure of api/user/{user}/reports/search
```shell
{
        "date": "YYYY-MM-DD"
}
```

## Endpoints Evidences API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/ | _ | .
