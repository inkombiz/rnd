app="app_inkombizz_web"
mvn package
docker rm $(docker stop $(docker ps -a -q --filter ancestor=${app} --format="{{.ID}}"))
docker build -t ${app} .
docker run -i -d -p 8080:8080 --name=${app} -v $PWD://usr/local/tomcat/webapps/ ${app}
