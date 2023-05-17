# demo

<a href="https://codeclimate.com/github/kapman17/demo/maintainability"><img src="https://api.codeclimate.com/v1/badges/007b64c5aca5a7066ad5/maintainability" /></a>
<a href="https://codeclimate.com/github/kapman17/demo/test_coverage"><img src="https://api.codeclimate.com/v1/badges/007b64c5aca5a7066ad5/test_coverage" /></a>

# Getting Started

## Setup

### Clone this Repo
```Bash
git clone https://github.com/kapman17/demo.git
```

### Gradle
Refer to the instructions in the shared repo to set up [Gradle](https://github.com/triplelift-internal/shared#gradle).

### Java
This is a standard Gradle project that compiles/runs with Java 17 JDK.

### Spring Annotations
For Intellij users, if the IDE cannot find functions on models with the [`@Data` annotation](https://projectlombok.org/features/Data), then [in project settings enable Annotation Processing and ensure the `Lombok` plugin is installed](https://stackoverflow.com/questions/24006937/lombok-annotations-do-not-compile-under-intellij-idea).

### Linting
Spotless is utilized to check formatting. Your PRs will fail to build if your formatting is improper. Ensure you install the proper formatter as specified below for your IDE.

- You can check formatting using:
  ```Bash
  ./gradlew :demo:spotlessCheck
  ```

- You may apply formatting using:
  ```Bash
  ./gradlew :demo:spotlessApply
  ```

## Running Locally

### Command Line
The simplest way to run the server is to open a new terminal window, and run it from the root of the project:
```Bash
cd demo
./gradlew :demo:clean && ./gradlew :demo:build
java -jar demo/build/libs/demo.jar
```

**Note**: There are other ways to run the application (e.g. in your IDE, or using `./gradlew :demo:bootRun`), but the above best
simulates how the jar is run in production, while other methods like `bootRun` might not catch subtle build-related bugs.

## Tests

### Unit Tests
The unit tests are run as part of the build.
```Bash
./gradlew :demo:clean && ./gradlew :demo:build
```

#### Cucumber
Gherkin feature files are in `test/resources/features`. Their counterpart step tests are in `/bdd/steps/`.
MySQL test data is defined in `test/resources/scripts/seed-mysql-data.sql` and auto-seeded to an in-memory H2 db.

#### JUnit
Non-BDD style unit tests can be added to the root test folder.

Mocking is done with Spring Boot Dependency injection, and mocks are configured in the TestConfig class.

https://cucumber.io/docs/cucumber/state/#spring

https://github.com/cucumber/cucumber-jvm/tree/master/spring

Be sure to set the profile to test in the BDD style tests.

### Integration Tests
The integration tests are run separately.
```Bash
./gradlew :demo:integrationTest
```

## Creating Cucumber Docs
Run the cukeDoctor gradle task and it will generate docs in the /docs folder: ``
```Bash
./gradlew :demo:cukeDoctor
```

## Deployment

### GitHub
- Open a feature branch from the latest `develop`.
- When the feature branch is approved, perform a squash merge into `develop` to start the sand CI/CD process.
- Open a PR from `develop` to `master`.
- When `develop` is approved, perform a REGULAR MERGE into `master` to start the prod CI/CD process. Do not squash merge into `master`! With squash merges, GitHub generates new commits instead of fast-forwarding the existing ones, resulting in a divergence between `develop` and `master`. This causes future PRs from `develop` into `master` to have merge conflicts.

### Github Actions
- See the "Actions" tab in Github for builds and deploys.
- The `master` and `develop` branches will trigger deployment.

### Deployment Strategy
This repository utilizes Github actions to trigger a CI/CD build pipeline as part of the `build-deploy` action
- This action starts whenever anything is pushed onto 'master'
- TBA
