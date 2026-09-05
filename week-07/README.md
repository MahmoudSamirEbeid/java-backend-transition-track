# Week 7 - Hibernate/JPA and Spring JDBC

This project demonstrates two database access approaches with Spring Boot and an in-memory H2 database.

## Hibernate/JPA

- `Course` is a JPA entity using `@Entity` and `@Id`.
- `CourseJpaRepository` demonstrates direct JPA CRUD with `EntityManager` and JPQL.
- `CourseSpringDataJpaRepository` extends `JpaRepository` and includes derived query methods.
- `CourseSpringDataJpaCommandLineRunner` demonstrates saving and querying entities.
- Hibernate is used by Spring Boot as the JPA provider.

## Spring JDBC

- `CourseJdbcRepository` uses `JdbcTemplate` and a custom `RowMapper<Course>`.
- It demonstrates insert, delete, find-by-id, and find-all SQL operations.
- `CourseJdbcCommandLineRunner` executes the JDBC operations with IDs `101` to `103`, separate from the JPA sample data.

## Run

```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```

The application uses `schema.sql` to create the `course` table in `jdbc:h2:mem:testDB`.
