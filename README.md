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
/ | _ | .

## Endpoints Lines and Stations API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/ | _ | .

## Endpoints Reports API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/ | _ | .

## Endpoints Evidences API
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/ | _ | .
