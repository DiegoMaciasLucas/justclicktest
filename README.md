# justclicktest
### Docker commands configuration:
##### Postgress:Database
*sudo docker run -d -it -p 5432:5432   --name db-postgres  -e POSTGRES_PASSWORD=admin     postgres
##### Adminer: Database Manager
*sudo docker run -d -it -p 8080:8080 --name adminer-postgres  adminer
##### ElasticSearch
*docker pull docker.elastic.co/elasticsearch/elasticsearch:7.13.3
*docker run -d -it -p 9200:9200 --name elasticSearch -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.13.3
##### SpringBoot: Test Services 
*docker build -t springio/gs-spring-boot-docker .
*docker run -d -it -p 8089:8089 --name justclickservice springio/gs-spring-boot-docker
*sudo docker cp ../justclicktest/src/main/resources/clicks.json justclicksercive:/opt
##### Note: execute docker build where is the DockerFile file, if any port is already used just change with other
### justclicktest file configuration
Change the ip address and port in the ../justclicktest/src/main/resources/application.properties with the respective previous created docker container
##### Note: Use start.sql file to create the database and insert data