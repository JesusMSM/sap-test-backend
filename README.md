# Backend for SAP assignment Mission to Mars

![Technologies](background.png)

## Architecture

Aiming to approach as maximum the technologies that would be used in the SAP position, this project uses Spring, Hibernate, MySQL, Java and Docker.
This project represents the backend of the whole project. 
The Model-Repository-Controller design pattern has been followed. Therefore there are two objects, Category and Item. Item has a foreign key pointing to a previously created category.
All the CRUD operations can be accesed by the controller and their routes have been exposed in order to call them in the front-end project.

## How to run it

Clone the repository and execute in the root folder:
```
docker-compose build
docker-compose up
```

Once it has been launched, it will be listening requests at the port 8087.

It can be found as well in docker hub: https://hub.docker.com/r/jesusmsanchez93/sap-test-backend/

```
docker pull jesusmsanchez93/sap-test-backend
```
