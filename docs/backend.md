# Backend
## Compiling
* `mvn -f ./backend/ package` to compile.
* `mvn -f ./backend/ package -Dmaven.test.skip=true package` to skip tests for compiling with the DB down.
* Omit `-f ./backend/` from above if running from within `/backend/`.

## Authentication
* Default username and password are defined in `src/main/resources/application.properties`