# Server side app using Spring Boot with Kotlin, Gradle, MongoDB, in async, reactive style

Features:

- Reactive, async implementation
- MongoDB database
- JUnit 5
- Gradle Kotlin

Reading list:

- [Painless Spring boot tutorial with Maven Kotlin & MongoDB](https://medium.com/mariano-z-lopez/painless-spring-boot-tutorial-with-maven-kotlin-mongodb-18c11a08aaae)
- [Reactive Flow with MongoDB, Kotlin, and Spring WebFlux](https://www.baeldung.com/kotlin-mongodb-spring-webflux)

## Development Experience Notes

Turn on auto rebuild and live reload

Run build with `--continuous` or `-t` option in one of the terminals.

```shell
$ gradle build --continuous --warning-mode all --parallel
```

In a separate terminal run the app

```shell
$ gradle runBoot
```

Turn on LiveReload in Chrome. Install LiveReload Chrome Extension, open Developer Console and activate LiveReload with clicking on its icon.

## Implementation steps

- Response for home page with `It's live message`

- Add `Configuration` to enable reactive MongoDB support (`ReactiveMongoConfiguration.kt`)
- Enable bean overriding support in `application.properties`
- Create Entities (models)
- Create Repositories (stores)

## Data Model

Product

```
id
name
price
```

Transaction

```
id
product_id
time_stamp
quantity
```
