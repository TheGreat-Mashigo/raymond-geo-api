

##  Tagging a Docker image ###
### docker build -t  shape-api/spring-boot-docker . ###

## Running docker images cmd ##
### docker images  to view the running images ###

## Running a Docker image  ##
### docker run -p80:3000 shape-api/spring-boot-docker ###

## To run the container in a detached mode, you can supply argument -d:
### docker run -d -p 80:80 hlogi/spring-boot-docker ###

## Re-tag the image with a version number: ##
### docker tag shape-api/spring-boot-docker shape-api/spring-boot-docker:v1 ###

## Push to dockerhub with  the following

### docker push shape-api/spring-boot-docker:v1

### list Docker containers: ### docker ps
### inspect a container: ### docker inspect <container-id>
### Docker logs in a Docker container: ### docker logs <container-id>
### stop a running container: ### docker stop <container-id>

## docker restart ##

### docker restart my_container ###

#### docker run -p 8080:8080 shape-api/spring-boot-docker

#### http://localhost:8080/v2/api-docs

## GET List of all shapes
#### http://localhost:8080/api/v1/shape/list

## create/add a shape
#### http://localhost:8080/api/v1/shape/save

## Swagger UI
#### http://localhost:8080/swagger-ui.html
