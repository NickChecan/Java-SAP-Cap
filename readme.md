* Command to create the project:
```
$ mvn -B archetype:generate -DarchetypeArtifactId=cds-services-archetype -DarchetypeGroupId=com.sap.cds \
-DarchetypeVersion=RELEASE \
-DgroupId=com.sap.cap -DartifactId=products-service -Dpackage=com.sap.cap.productsservice
```

* Command to print working directory:
```
$ pwd
```

* Clear old files and install the project dependencies:
```
$ mvn clean install
```

* Execute the application:
```
$ mvn clean spring-boot:run
```

* To Expose the ports you are working with, you can access **View > Find Command**, enter the option "Port: Expose" and inform the port number.
You can view the exposed ports by accessing the "Ports: Preview" the same way

* Command to quick execute the application:
```
$ cd ~/projects/products-service && mvn clean spring-boot:run
```

* CURL to insert data on the product tables through a POST http method:
```
curl -X POST http://localhost:8080/odata/v4/AdminService/Products \
-H "Content-Type: application/json" \
-d '{"ID": 42, "title": "My Tutorial Product", "descr": "You are doing an awesome job!"}'
```

* Install the sqlite3 plugin
```
$ npm install --save-dev sqlite3
```

* Initialize the database with the defined domain model:
```
cds deploy --to sqlite
```

* In case of any error with the cds deploy command with the sqlite, refer to the sap post bellow:
https://answers.sap.com/questions/13041405/error-cannot-find-module-sqlite3-in-sap-cap-model.html
Execute the following command to avoid any more issues:
```
1. execute npm install in your application's root directory.
2. execute unset NODE_PATH in terminal. You need to do this in every new terminal window.
After executing above 2 commands try executing cds deploy --to sqlite.
```

* Add mock data to the SQLITE tables:
```
curl -X POST http://localhost:8080/odata/v4/AdminService/Categories \
-H "Content-Type: application/json" \
-d '{"ID": 1, "name": "TechEd", "descr": "TechEd related topics", "children": [{"ID": 10, "name": "CAP Java", "descr": "Run on Java"}, {"ID": 11, "name": "CAP Node.js", "descr": "Run on Node.js"}]}'
```

* Commands to query data through the service endpoint:
```
/odata/v4/AdminService/Categories?$expand=children
/odata/v4/AdminService/Categories(10)?$expand=parent
/odata/v4/AdminService/Categories(1)?$expand=children
```

Reference:
https://developers.sap.com/mission.cap-java-app.html