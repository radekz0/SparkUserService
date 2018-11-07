# RESTful API project

It's a simple web app made in a Spark micro framework.
The server we are connecting to is local.
In this project you can:
* Add users.
* Print all users.
* Print a user of certain id.
* Check if a user exists.
* Remove a user of certain id.

It's done via HTTP requests sent in Postman (API Development Environment).

**Route form:**

http://localhost:4567/used_path

The body of a request is in a Json structure. 
All data is stored in a local database managed via DbController class, where connection to a db and all CRUD methods are created.
