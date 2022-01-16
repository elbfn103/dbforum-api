This is the back-end API for [DB Forum](https://github.com/ker1200/nwHacks-2022).

It's coded mainly in Java + Spring Boot, and connects to MongoDB over the cloud
for the database.

To run this API, simply clone the repository and run `DbForumAPIApplication` as a
Spring Boot App. Make sure your Maven dependencies are injected correctly, and that you're
running the project in Java 17+.

Once the server has started, you should be able to hit the API at
`http://localhost:8081/dbforum/` + whatever endpoint you desire.

Currently supported endpoints:

`http://localhost:8081/dbforum/posts`
GET Request - retrieves all posts in the database

`http://localhost:8081/dbforum/post/{id}`
GET Request - retrieves a post by the given id from the database

`http://localhost:8081/dbforum/post`
POST Request - creates/saves a post in the database, takes a `Post` object
in the request body

`http://localhost:8081/dbforum/post`
PUT Request - updates a post in the database, takes a `Post` object in the
request body

`http://localhost:8081/dbforum/post/{id}`
DELETE Request - deletes a post by the given id in the database