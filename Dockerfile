FROM maven:latest
MAINTAINER jrivesan@everis.com
 
RUN apk update
 
ENV APP_HOME /home
RUN mkdir -p $APP_HOME
 
ADD putridparrot.jar $APP_HOME/putridparrot.jar
 
WORKDIR $APP_HOME
 
EXPOSE 8080
 
CMD ["java","-Dspring.data.mongodb.uri=mongodb://db:27017/","-jar","/home/putridparrot.jar"]
