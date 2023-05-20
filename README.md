# Project-Programming-2-2022

Microservices programming project 

## Starting 🚀

- Cloning Project:
```
https://github.com/MartinMosqueira/Project-Programming-2-2022.git
```

### Pre-requisites 📋

- java : 17 (openjdk 17.0.4.1)
- maven : 3.8.6

### Installation 🔧

- Docker Images:
```
- docker pull consul
- docker pull postgres
```
- Run consul container:
```
- sudo docker run --name=consul -p 8500:8500 consul
```
- Run postgres container:
```
- docker run -p 5432:5432 --name MsFranchise -v /var/lib/docker/volumes/FranchiseStorage/_data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=1234 -d postgres:latest
- docker exec -it MsFranchise psql -U postgres
- CREATE DATABASE franchisestorage;
- \q
```
- Run project:
```
- mvn install
- mvnw spring-boot:run
```

## Authors ✒️
* **Martin Mosqueira** - *Documentation* - [Martin Mosqueira](https://github.com/MartinMosqueira)

---
⌨️ con ❤️ por [Martin Mosqueira](https://github.com/MartinMosqueira) 😊
