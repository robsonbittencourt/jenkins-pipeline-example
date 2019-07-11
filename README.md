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

### Jenkins configurations

- Habilitar o maven em tools
- Instalar o plugin Pipeline Maven Plugin