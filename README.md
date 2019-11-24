# Academic ERP

## Configuration File
Update configurations in the following files:

* #### Database details:
```
/academicerp/src/main/resources/hibernate.properties
```
* #### Other Configurations:
```
/academicerp/src/main/resources/config.properties
```

## Running the Application
* Download the Tomcat Server
* Add its configuration to your project
* Add the exploded war artifact to the deployment
* Set the Application Context

## Initialising the Database
You may initialise the Domain table using the following or similar query:
```
INSERT INTO Domain(discipline, branch, code) VALUES
("M.Tech", "CS", "MTC"),
("M.Tech", "EC", "MTE"),
("iMTech", "CS", "IMTC"),
("iMTech", "EC", "IMTE"),
("MS", "CS", "MSC"),
("MS", "EC", "MSE");
```

## Troubleshooting
If the changes made in your project don't reflect in your browser kindly: 
* Clear Browser Cache & Cookies
* Delete the ```/target``` directory
* Run on the IntelliJ Terminal ```$ mvn clean install```

## Projects
To view the list of projects click on the link below:

[List of Projects](https://github.com/anshgyl/academic-erp/blob/master/PROJECTS.md)