app="web_app"
mvn package
docker rm $(docker stop $(docker ps -a -q --filter ancestor=${app} --format="{{.ID}}"))
docker build -t ${app} .
docker run -i -d -p 8282:8080 --name=${app} -v $PWD:/app ${app}
