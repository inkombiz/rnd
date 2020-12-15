app="api-inkombizz-master"
docker rm $(docker stop $(docker ps -a -q --filter ancestor=${app} --format="{{.ID}}"))
docker build -t ${app} .
docker run -i -d -p 9010:9010 --name=${app} -v $PWD:/app ${app}
