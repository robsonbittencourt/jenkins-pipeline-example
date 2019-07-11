# Jenkins Pipeline Example


### Run unit tests
```mvn test```

### Run integration tests
```mvn verify -Pit-tests```

### Run ui tests
```mvn verify -Pui-tests```

### Show Allure Report
```mvn allure:serve```

### Run unit tests, integration tests and Sonarqube Analisys 
```mvn verify -Psonar```


### Docker compose

```
docker pull elgalu/selenium

docker-compose up -d
```

### Docker Swarm

```
To up - docker stack deploy --compose-file docker-compose.yml stackdemo

To down - docker stack rm stackdemo
```

### Jenkins configurations

- Add your Dockerhub user and pass in credential with ID 'registryCredential' in Jenkins