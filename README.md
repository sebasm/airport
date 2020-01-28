Airport

	This application loads and serves flights, it exposes a REST API with two endpoints and stores the data in a H2 volatile database.


How to run this application?

	Just execute "mvn spring-boot:run" in the commnad line


How to test the requirements?

	There are three files in the root, flights.csv, flights.json and flights.xml. Each one of them has 4 declared flights.
	Once you have the application running you can load the files into the airtport through a post to:

		localhost:8080/flights

		in the form data you must declare a key with the name "file" and send any of those files


	Once you loaded the files you can see them in the DB, accesing http://localhost:8080/h2-console
	and using "jdbc:h2:mem:testdb" in JDBC URL field.

	To get a file with the loaded flights you can do a GET to localhost:8080/flights from your browser
	By default you will get the results in CSV, but you can specify different formats eg:

		localhost:8080/flights?format=xml
		localhost:8080/flights?format=json
		localhost:8080/flights?format=csv






