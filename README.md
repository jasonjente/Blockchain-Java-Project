# Blockchain-Java-Project
Simple Java Blockchain application using Akka reactive streams and spring boot for the application deployment and repository(db) handling.

Akka streams which validate the stream of transactions and mine the blocks.

Application module contains the spring boot application.

The two modules are independent.

There is a REST endpoint also in order to populate the database with transactions.
In the near future these transactions will be validated through a service layer connecting them to the akka streams.
