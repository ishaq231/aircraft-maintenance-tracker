# Aircraft Maintenance Tracker

A Java application for tracking aircraft components and flagging when they're due for maintenance based on logged flight hours. Built as a personal project to gain hands-on Java experience, applying object-oriented design principles already used in Python projects to a statically typed language.

## What it does

- Models aircraft and their components (engines, landing gear, etc.), each with a maintenance threshold in flight hours
- Logs flight hours against a specific aircraft, updating every component it carries
- Returns which components have crossed their maintenance threshold, so the caller decides how to notify the user, keeping logic and display separate
- Validates input and throws clear, specific exceptions for invalid data (missing aircraft, empty registration numbers, negative hours)

## Tech stack

- Java 17
- Maven (dependency management and build)
- JUnit 5 (testing)

## Project structure

```
aircraft-maintenance-tracker/
├── pom.xml
├── src/
│   ├── main/java/
│   │   ├── Component.java
│   │   ├── Aircraft.java
│   │   ├── MaintenanceTracker.java
│   │   └── AircraftNotFoundException.java
│   └── test/java/
│       └── MaintenanceTrackerTest.java
```

## Design notes

- **Separation of concerns**: `MaintenanceTracker.logFlightHours()` returns the list of overdue components rather than printing directly, keeping business logic independent of how results are displayed.
- **Encapsulation choices are deliberate, not default**: fields representing identity (part number, type) have no setters; fields representing mutable state (flight hours, maintenance threshold) do.
- **Custom exception handling**: `AircraftNotFoundException` distinguishes "aircraft not found" from "aircraft found, nothing overdue", two outcomes that would otherwise look identical to the caller.

## Running it

Run the tests:
```
mvn test
```

Compile and run the demo in `main`:
```
mvn compile exec:java -Dexec.mainClass="MaintenanceTracker"
```

## Tests

5 JUnit tests covering component tracking, correct overdue detection, and error handling for missing aircraft, empty registration numbers, and negative flight hours.
