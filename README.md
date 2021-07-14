

##  Create Docker image ###
### docker build -t  hlogi/spring-boot-docker . ###
### docker image build -t  hlogi/spring-boot-docker . ### step 1

## Running docker images cmd ##
### docker images  ls    ## to view the running images ###

## Running a Docker image  ## Step 2
### docker container run -p 8080:8080 hlogi/spring-boot-docker ###

## To run the container in a detached mode, you can supply argument -d: ### ## Step 3
### docker run -d -p 8080:8080 hlogi/spring-boot-docker:v1 ###

## Re-tag the image with a version number:
### docker tag hlogi/spring-boot-docker hlogi/spring-boot-docker:v1 ###


## Push to dockerhub with  the following

### docker push hlogi/spring-boot-docker:v1

### list Docker containers: ### docker ps

### inspect a container: ### docker inspect <container-id>

### Docker logs in a Docker container: ### docker logs <container-id>

### stop a running container: ### docker stop <container-id>

## docker restart ##

### docker restart my_container ###

#### docker run -p 8080:8080 hlogi/spring-boot-docker

### Swagger url 
#### http://localhost:8080/swagger-ui.html#/

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