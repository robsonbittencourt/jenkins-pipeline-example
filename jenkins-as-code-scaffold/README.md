# Jenkins as Code Scaffold

> Scaffold to create a Jenkins instance all maintained by code

# Motivation

The goal of this project is to create a scaffold Jenkins defined by code. With all the settings being made through code instead of using the graphical interface, it is possible to have several benefits such as change management, and fast Jenkins replication.

# Running

```
# Build your Docker image. Use your favorite name myjenkins it's just an example.
docker build -t myjenkins .

# Run jenkins container
docker run -p 8080:8080 -p 50000:50000 myjenkins
``` 

Access http://localhost:8080 and your Jenkins instance is up.

![jenkins](images/jenkins-job.png)

Some things are already set up to serve as an example.

- A job configured tu use a pipeline
- Some tools like JVM and Maven
- A fake credential
- Some Jenkins general configuration

In addition, a list of plugins (defined in the plugins.txt file) will already be installed.

# Usage in real life

## Add more configurations

You can clone this project and make your settings as needed. All Jenkins definitions are found in the [definitions](definitions) folder.

If you need any configuration that is not in the examples of this project do the following:

- Make your modification through the graphical interface.
- Access [this link](http://localhost:8080/configuration-as-code/viewExport) and copy the configuration to the appropriate YAML file.

![jenkins-as-code-config](images/jenkins-as-code-config.png)

## Update Plugins

If you update plugins using interface and you want them to be defined in the code, execute the commands below:

``` 
JENKINS_HOST=admin:admin@localhost:8080

curl -sSL "http://$JENKINS_HOST/pluginManager/api/xml?depth=1&xpath=/*/*/shortName|/*/*/version&wrapper=plugins" | perl -pe 's/.*?<shortName>([\w-]+).*?<version>([^<]+)()(<\/\w+>)+/\1 \2\n/g'|sed 's/ /:/' | sort > plugins.txt
```

This will update the plugins.txt file with the plugins that are currently installed.

# Behind the Stage

This project is based on the [Jenkins Configuration as Code Plugin](https://github.com/jenkinsci/configuration-as-code-plugin) which allows Jenkins settings to be defined by code.

[Jenkins Docker image](https://hub.docker.com/_/jenkins) was also used, which facilitates the execution and also prior definition of plugins.