# api-tests
This repository contains some API tests for the endpoints provided by the [Best Buy - API Playground](https://github.com/bestbuy/api-playground).

## Tech stack
1. Java 11
2. Maven
3. TestNG
4. REST-assured
5. Lombok

## Pre-requisites
Best Buy - API Playground environment must be set up locally as per [this guide](https://github.com/bestbuy/api-playground/#getting-started).

## Running the tests
 `mvn clean compile test`

## Notes
1. Since the project uses the dependencies from [the Lombok project](https://projectlombok.org), please install the Lombok IntelliJ plugin (if you are using the IntelliJ IDEA IDE) and enable Lombok annotation processing so that the annotations used in this project get compiled without any issues. Here's how to enable Lombok annotation processing in IntelliJ IDEA.
- Go to `Preferences`
    - `Build, Execution, Deployment`
        - `Compiler`
            - `Annotation Processors` -> `Enable annotation processing`

