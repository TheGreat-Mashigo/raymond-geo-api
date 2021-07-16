

##  Create Docker image ###
### docker build -t  hlogi/spring-boot-docker:v2 . ###

## Running docker images to view the running images ##
### docker images  ls     ###

## Running a Docker image  ## 
### docker run -p 8080:8080 hlogi/spring-boot-docker:v2 ###

## Re-tag the image with a version number:
### docker tag hlogi/spring-boot-docker:v2 hlogi/spring-boot-docker:v3 ###


## Push to dockerhub with  the following

### docker push hlogi/spring-boot-docker:v2

### list Docker containers: ### docker ps

### inspect a container: ### docker inspect <container-id>

### Docker logs in a Docker container: ### docker logs <container-id>

### stop a running container: ### docker stop <container-id>

## docker restart ##

### docker restart my_container ###

[comment]: <> (Running Swagger)
### [Swagger url](http://localhost:8080/swagger-ui.html#/)

## GET List of all shapes
#### http://localhost:8080/swagger-ui.html#/shape-rest/listAllUsingGET

## create/add a shape
#### http://localhost:8080/swagger-ui.html#/shape-rest/saveUsingPOST

## Swagger UI
#### http://localhost:8080/swagger-ui.html


#### http://localhost:8080/v1/api/swagger-ui.html
#### http://localhost:8080/api/v1/swagger-ui.html

## To delete all containers including its volumes use
### docker rm -vf $(docker ps -a -q)

## To delete all the images
### docker rmi -f $(docker images -a -q)
### docker images prune

## run the docker image using image id
### docker run -i -t f994713b61cb /bin/bash