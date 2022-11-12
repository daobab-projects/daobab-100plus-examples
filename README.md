#daobab-100plus-examples

Over 100 Daobab ORM examples, ready to instant use.

#How to run?
A few ways:
1. Go to the specific example and run the main method inside the class.
2. Run a unit test
3. Run DemoApplication to start the examples via http page http://localhost:9000/

Along with application, a dedicated H2 database instance is created and fulfilled.

You may connect to the database browser right here: http://localhost:9000/h2

#How to run the remote server examples?
In order to run the remote server examples, just run the application instance via DemoApplication class to create a remove server.
After this, the examples related to the remote querying should be fine.
You may run them by the internal main method for example.

#Running on a Mac or Linux?
By default, the project is designed to work withing a Windows environment.
To change it, please modify the key <b>spring.datasource.url</b> into the application.properties file, so that the path would be correct.

#Problems during the H2 startup?
Try to remove the previous h2 database file (C:/temp/daobab/daobab.mv.db by default).
The new one will be created. Most likely the previous version is not compatible anymore.

#Enjoy Daobab
For any information, please visit http://www.daobab.io
