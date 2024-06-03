# User Application

This web application is developed using HTML forms, Tomcat, Servlets, JDBC, and SQL. 
It enables users to perform various operations such as adding, updating, viewing, and removing users. 
Created as part of the "Java Web Development" course, this application is intended for educational purposes. 
It serves as a foundational project before transitioning to development with JSP and JSTL.


## Prerequisites

Before running the application, make sure you have the following installed:

- Apache Tomcat: [Download](https://tomcat.apache.org/download.cgi)
- Java Development Kit (JDK): [Download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- MySQL Database: [Download](https://dev.mysql.com/downloads/installer/)
- mysql-connector-j-8.4.0.jar: [Download](https://dev.mysql.com/downloads/connector/j/)

## Setup

<ol>
  <li>Clone the repository or download the source code.</li>
  <li>Import the project into your preferred IDE.</li>
  <li>Add the `mysql-connector-j-8.0.23.jar` file to the project's build path.</li>
  <li>Configure the database connection in the `config.properties` file.</li>
  <li>Build and deploy the application to your Tomcat server.</li>
</ol>

## Usage

## Usage

1. Start your Tomcat server.
2. Open your web browser and navigate to `http://localhost:8080/UserApplication`.
3. You will see the homepage to add user details and perform CRUD operations.
4. Click on the respective links to perform the desired operation.
5. To view or edit a user's details, navigate to `http://localhost:8080/UserApplication/updateUser`, to update the user details,
 replace `updateUser` with the url pattern with other action you want to perform.


 ## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## Thank you for using the application!
