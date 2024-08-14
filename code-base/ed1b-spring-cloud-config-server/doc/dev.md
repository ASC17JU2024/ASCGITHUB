

:newspaper: **ed1a-limits-service > get configuration form application properties** ..  

:one: application properties  
```properties
spring.application.name=limits-service
limits-service.minimum=9
limits-service.maximum=999
```
:two: model using lombok
```java
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LimitConfiguration {
   @Getter
   private int maximum;
   @Getter
   private int minimum;
}
```
:three: configurure properties
```java
@Component
//limits-service is the prefix for properties in the configuration file.
@ConfigurationProperties("limits-service")
public class Configuration {
```
:four: app
```java
@RestController
public class LimitsConfigurationController {

   @Autowired
   Configuration configuration;

   @GetMapping("/limits")
   public LimitConfiguration retrieveLimitsFromConfigurations() {
      return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
   }
}
```  
:five: run   
```http
http://localhost:8080/limits
```
----------


:newspaper: **ed1b-spring-cloud-config-server > Setting up Spring Cloud
Config Server** ..  


:one: add dependency
```xml
<properties>
      <java.version>1.8</java.version>
      <spring-cloud.version>Greenwich.SR5</spring-cloud.version>
</properties>

<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-config-server</artifactId>
</dependency>

<dependencyManagement>
      <dependencies>
         <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
         </dependency>
      </dependencies>
   </dependencyManagement>
```
:two: install git
```sh
$ git --version
git version 2.24.0.windows.2
```
:three: ed1c-git-localconfig-repo create local repo
```sh
$ mkdir ed1c-git-localconfig-repo
$ cd ed1c-git-localconfig-repo
$ git init
```
:link: https://git-scm.com/docs/      

:four: ed1b-spring-cloud-config-server application.properties
```properties
spring.application.name=spring-cloud-config-server
server.port=8888
```
:five: link source ed1c-git-localconfig-repo   
- eclipse : 
   -  build path > link source  
- idea : 
   -  File | Project Structure > Project Settings | Modules. 
   - Select necessary module > Sources > Add Content Root > specify the folder that you want to add as a new content root.   

:six: ed1c-git-localconfig-repo limits-service.properties
```properties
limits-service.minimum=8
limits-service.maximum=888
```
:seven: git commit  
```sh
$ git add -A
$ git commit -m "added limits-service properties"
```
:eight: ed1b-spring-cloud-config-server  application.properties
```properties
spring.application.name=spring-cloud-config-server
server.port=8888
spring.cloud.config.server.git.uri=file:///Z:/explorE/eCourse/mas-ms-sp-sc/mx-master-i1/demos/d02-spring-cloud-config-server
```
:nine: annotate the app    
```java
@EnableConfigServer
@SpringBootApplication
public class App {
```
:one::zero: create dev and qa profiles
- ed1c-git-localconfig-repo\limits-service-dev.properties
```properties
limits-service.minimum=1
limits-service.maximum=111
```
- ed1c-git-localconfig-repo\limits-service-qa.properties
```properties
limits-service.minimum=2
limits-service.maximum=222
```

:arrow_forward: http://localhost:8888/limits-service/default  
:arrow_forward: http://localhost:8888/limits-service/dev      
:arrow_forward: http://localhost:8888/limits-service/qa    

----------


