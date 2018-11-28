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