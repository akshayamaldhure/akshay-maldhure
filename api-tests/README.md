# api-tests
This repository contains some API tests for the endpoints provided by the [Best Buy - API Playground](https://github.com/bestbuy/api-playground).

## Test cases proposed for automation
This repository contains tests for various APIs like /entitys, /categories, /stores, /services, /version offered by the [Best Buy - API Playground](https://github.com/bestbuy/api-playground). The test framework also uses the /healthcheck API as a pre-requisite/pre-run check before running any of the tests.

#### Entity API (where an entity could be a entity, category, service or store)
| Test | HTTP method | Expected condition |
| ---- | ----------- | ------------------ |
| Verify the default limit | GET | Should return 10 entity objects by default. |
| Verify the custom limit and skip parameters | GET | Should return the entity objects as per the limit and skip values passed. |
| Verify entity details | GET | Should return the entity object with matching expected entity name. |
| Verify entity details for an invalid entity id | GET | Should return 404. |
| Verify entity creation | POST | Should create the entity with pre-defined attributes and the `createdAt` timestamp should be populated accordingly. |
| Verify entity update | PATCH | Should update the entity with the new name and the `updatedAt` timestamp should be updated. |
| Verify delete for an invalid entity id | DELETE | Should return 404. |

## Tech stack
1. Java 8
2. Maven
3. TestNG
4. REST-assured
5. Lombok

## Pre-requisites
Best Buy - API Playground environment must be set up locally as per [this guide](https://github.com/bestbuy/api-playground/#getting-started) and must be up and running before running any tests.

## Running the tests
 `mvn clean compile test`
 
## Issues faced
1. I could not write any tests that could use the entity class to serialize the entity object, e.g. using the `Product` class object to create a payload using Lombok Builder to create a new entity using the /products API as I ran into the `UnRecognizedPropertyException` for such cases.
2. I could not find any effective ways to refactor the various test classes that have repetitive code. 

## Notes
1. Since the project uses the dependencies from [the Lombok project](https://projectlombok.org), please install the Lombok IntelliJ plugin (if you are using the IntelliJ IDEA IDE) and enable Lombok annotation processing so that the annotations used in this project get compiled without any issues. Here's how to enable Lombok annotation processing in IntelliJ IDEA.
- Go to `Preferences`
    - `Build, Execution, Deployment`
        - `Compiler`
            - `Annotation Processors` -> `Enable annotation processing`

