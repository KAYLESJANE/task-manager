# Read Me First
# Task Manager Application

This is a simple Task Manager REST API built with Spring Boot. The application allows users to create, retrieve, update, and delete tasks, with additional AI features to assist users with task management. The application is connected to a MySQL database to persist task data.

## Features
1. **CRUD Operations for DataModels**
    - Create, read, update, and delete tasks (DataModels) via RESTful endpoints.

2. **AI Features**
    - **Smart Task Suggestions**: Suggests task titles or descriptions based on user input.
    - **Due Date Prediction**: Predicts task due dates based on historical data (currently mocks a 3-day prediction).

3. **Database Integration**
    - All task data is persisted in a MySQL database using JPA and Hibernate.

## Future Enhancements
1. **Automation Features**
    - **Reminder Notifications**: Background jobs to remind users of tasks due within 24 hours.
    - **Recurring Tasks**: Ability to mark tasks as recurring (daily, weekly, monthly), and automatically create new tasks at the specified intervals.

## API Endpoints
- `GET /datamodel/{modelId}`: Get details of a specific task.
- `GET /datamodel`: Get all tasks.
- `POST /datamodel`: Create a new task.
- `PUT /datamodel/{modelId}`: Update an existing task.
- `DELETE /datamodel/{modelId}`: Delete a task.
- `POST /tasks/suggest`: Get AI-based task suggestions.
- `POST /tasks/{id}/predict-due-date`: Predict a due date for a task.

## Getting Started
1. Clone the repository.
2. Set up a MySQL database and configure the `application.properties` file.
3. Run the application with `./mvnw spring-boot:run` (or the equivalent Maven command).

## Dependencies
- Spring Boot
- Spring Data JPA
- MySQL

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

