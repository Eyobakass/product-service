# Reflection Questions

## 1. Why should the ProductRequest DTO carry @Valid instead of the Product entity?

The ProductRequest DTO represents external input from the client, so validation should happen at the boundary before data reaches the business layer. The entity represents the database model and should not be exposed to invalid external data. Using @Valid on the DTO ensures clean separation of concerns and prevents invalid persistence states.

---

## 2. Purpose of Location header in 201 Created

The Location header indicates the URI of the newly created resource. It allows the client to immediately know where the created resource can be accessed. This is defined in the HTTP/1.1 specification (RFC 9110). It improves REST compliance and discoverability.

---

## 3. Difference between @ControllerAdvice and @ExceptionHandler

@ExceptionHandler handles specific exceptions inside a single controller class.  
@ControllerAdvice is a global exception handler that applies to all controllers.

We use @ExceptionHandler for local handling and @ControllerAdvice for centralized error handling across the application.

---

## 4. Effect of removing @Transactional in tests

Without @Transactional, changes made in one test would persist into the database and affect other tests. This leads to test pollution and unreliable test results. With @Transactional, each test runs in isolation and rolls back changes after execution.

---

## 5. What does RFC 9457 define?

RFC 9457 defines a standard format for problem details in HTTP APIs. It provides a structured JSON response for errors instead of generic messages. This improves consistency, machine readability, and debugging compared to simple error strings like { error: "something went wrong" }.

---

## 6. Difference between integration test and unit test

A unit test (Mockito) tests individual components in isolation by mocking dependencies.  
An integration test (MockMvc) tests the full request-response flow including controllers, services, and sometimes repositories.

Unit tests are faster and used for logic validation. Integration tests ensure the system works end-to-end.
