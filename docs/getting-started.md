# Getting started
## Using Docker
### Installation
* https://hub.docker.com/editions/community/docker-ce-desktop-windows
* https://hub.docker.com/editions/community/docker-ce-desktop-mac

### Running the app
* Now, the app and everything else you might need for development can be started with one simple command 
  in the project directory!

  ```docker-compose up```

* The frontend React app will be live on ```localhost:3000```
* The backend Spring app will be live on ```localhost:5000```
* The database will be live on ```localhost:3306```

### Closing the app 
* The app can be stopped with CTRL + C (Or whatever appropriate command on your OS) then just run the code below 
  to stop and remove the other containers if desired

  ```docker-compose down```
  
## Setting up the development environment with IntelliJ
### Frontend
### Set up frontend module in IntelliJ
* TODO (It is pretty much like the `Set up backend module in IntelliJ` section below)

### Backend
#### Set up backend module in IntelliJ
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
  
#### Auto Reloading / LiveReload
* Auto reloading a Spring application with Docker requires Spring Boot Remote.
* Open the `Run/Debug Configurations`.
* Add a new configuration using the `+` button and add `Spring Boot`.
* Under `Name:` put `RemoteApplication` or whatever you wish.
* Under `Main class:` put `org.springframework.boot.devtools.RemoteSpringApplication`.
* Under `Program arguments: ` put `http://localhost:5000`.
* Under `Use classpath of module` put `backend`.
  * If this module does not already exist, you will have to create it. Check the section above on setting up 
    the backend module in IntelliJ.
* Then `Run RemoteApplication`. This will start Spring Boot Remote as a service.
* Now whenever a change is made in the backend application, one can simply `Build Project (CTRL + F9)` or 
  `Build Module` and LiveReload will be triggered.
* Optionally, to get IntelliJ to auto compile and build on saves, refer to the following 
  `https://stackoverflow.com/questions/12744303/intellij-idea-java-classes-not-auto-compiling-on-save` 

### Database
#### Set up db module in IntelliJ
* Open the `Project Structure (CTRL + ALT + SHIFT + S)`.
* Go to `Modules` and add a new module by pressing the `+` button followed by `New Module`.
* Click `Java` or whatever. It is not so important here what you choose as this module will have no source code.
* Set the `Module name:` to be `db`.
* Set the `Content root:` to be `Plugga/db` or wherever the `db` folder is located.
* Click `Finish`
* Now in `Project Structure | Modules` you should see the `db` module
* Navigate over to the project view on the left, select `db` and delete the `src` folder as again, this module will
  not contain any source code.
  
#### Set up the data source in IntelliJ
* Open the database tool window by going to `View | Tool Windows | Database`
* Click the `+` and `Datasource | MySQL`
* Fill in the fields using the environment variables found in `docker-compose.yml`