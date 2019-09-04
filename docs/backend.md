# Backend
## Compiling
* `mvn -f ./backend/ package` to compile.
* `mvn -f ./backend/ package -Dmaven.test.skip=true package` to skip tests for compiling with the DB down.
* Omit `-f ./backend/` from above if running from within `/backend/`.

## Setting up the backend module in IntelliJ
* Open the `Project Structure (CTRL + ALT + SHIFT + S)`.
* Go to `Modules` and add a new module by pressing the `+` button followed by `New Module`.
* Click `Spring`.
* Set the `Module name:` to be `backend` or whatever you wish.
* Set the `Content root:` to be `Plugga/backend` or wherever the `backend` folder is located.
* Click `Finish`
* Configuring the sources
  * In `Project Structure` go to `Modules` under `Project Settings` and click on the `backend` module
  * Set `src/main/java` as the `Sources` folder in blue
  * Set `serc/main/resources` as the `Resources` folder
  * Set `src/test/java` as the `Test` folder in green
  * Set `target` as `Excluded Folders`
  * Click `Okay`

## Auto Reloading / LiveReload
* Auto reloading a Spring application with Docker requires Spring Boot Remote.
* In **IntelliJ**
  * Open the `Run/Debug Configurations`.
  * Add a new configuration using the `+` button and add `Spring Boot`.
  * Under `Name:` put `RemoteApplication` or whatever you wish.
  * Under `Main class:` put `org.springframework.boot.devtools.RemoteSpringApplication`.
  * Under `Program arguments: ` put `http://localhost:5000`.
  * Under `Use classpath of module` put `backend`.
    * If this module does not already exist, you will have to create it. Check the section above on setting up 
      the backend module in IntelliJ.
  * Then `Run RemoteApplication`. This will start Spring Boot Remote as a service.
  * Now whenever a change is made in the backend application, one can simply `Build Project (CTRL + F9)` and
    LiveReload will be triggered.