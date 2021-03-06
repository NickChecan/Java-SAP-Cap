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
