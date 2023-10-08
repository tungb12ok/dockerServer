FROM tomcat:10.0-jdk8

COPY ./dist/FCourse.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080

CMD ["catalina.sh", "run"]