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

:three: configure properties

```java
@Component
//limits-service is the prefix for properties in the configuration file.
@ConfigurationProperties("limits-service")
public class Configuration {
```

:four: LimitsConfigurationController

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

:arrow_forward: http://localhost:8080/limits

---

:newspaper: **ed1b-spring-cloud-config-server** ..

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

:three: ed1c-git-localconfig-repo

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
  - build path > link source
- idea :
  - File | Project Structure > Project Settings | Modules.
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

:eight: ed1b-spring-cloud-config-server application.properties

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

---

:newspaper: **ed1e-currency-conversion-service Connect Limits Service to Spring Cloud
Config Server** ..  
:one: add dependency

```xml
   <properties>
      <java.version>1.8</java.version>
      <spring-cloud-services.version>2.1.7.RELEASE
      </spring-cloud-services.version>
      <spring-cloud.version>Greenwich.SR5</spring-cloud.version>
   </properties>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
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
         <dependency>
            <groupId>io.pivotal.spring.cloud</groupId>
            <artifactId>spring-cloud-services-dependencies</artifactId>
            <version>${spring-cloud-services.version}</version>
            <type>pom</type>
            <scope>import</scope>
         </dependency>
      </dependencies>
   </dependencyManagement>
```

:two: ed1e-currency-conversion-service bootstrap.properties

```properties
# fetch configuration information from config server
# overrides settings in application.properties
spring.application.name=limits-service
spring.cloud.config.uri=http://localhost:8888
```

:arrow_forward: http://localhost:8080/limits  
`properties are fetched from the config server`

```json
{
  "maximum": 888,
  "minimum": 8
}
```

:three: set dev as active profile

```properties
spring.profiles.active=dev
```

:loudspeaker: _2 key steps in configuration_

- create "springapp.profile" in git repository
- add property spring.cloud.config.uri in client microservice

---

:newspaper: **ed1e-currency-conversion-service** ..

:label: _hard coded currency
exchange service_

:one: ed1e-currency-conversion-service\src\main\resources\application.properties

```properties
spring.application.name=currency-exchange-service
server.port=8000
```

:two: ed1e-currency-conversion-service mdl\ExchangeValue.java

```java
@AllArgsConstructor
public class ExchangeValue {
   @Getter
   @Setter
   private Long id;
   @Getter
   @Setter
   private String from;
   @Getter
   @Setter
   private String to;
   @Getter
   @Setter
   private BigDecimal conversionMultiple;
}
```

```java
@RestController
public class CurrencyExchangeController {
   @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
   public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
      return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
   }
}
```

:arrow_forward: http://localhost:8000/currency-exchange/from/USD/to/INR

```json
{
  "id": 1000,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65
}
```

:label: _Dynamic Port in the the
Response_

:one: ExchangeValue

```java
 @Getter
   private int port;
```

:two: CurrencyExchangeController

```java
public class CurrencyExchangeController {
   @Autowired
   Environment environment;

   @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
   public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
      int port = Integer.parseInt(environment.getProperty("local.server.port"));
      return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), port);
   }
}
```

:arrow_forward: http://localhost:8000/currency-exchange/from/USD/to/INR

```js
{
    "id": 1000,
    "from": "USD",
    "to": "INR",
    "conversionMultiple": 65,
    "port": 8000
}
```

:label: _virtual machine arguments_

- `-Dserver.port=8001`
- _vm port overrides application properties_  
  :arrow_forward: http://localhost:8001/currency-exchange/from/USD/to/INR

```json
{
  "id": 1000,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65,
  "port": 8001
}
```

:label: _Configure JPA and Initialized Data_

:one: jpa & h2 in-memory detabase

```xml
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>
      <!-- in memory database -->
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>
```

:two: ExchangeValue @NoArgsConstructor @Id @Column

```java
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeValue {
   @Getter
   @Setter
   @Id
   private Long id;
   @Getter
   @Setter
   @Column(name = "currency_from")
   private String from;
   @Getter
   @Setter
   @Column(name = "currency_to")
   private String to;
```

:three: application.properties

```properties
spring.application.name=currency-exchange-service
server.port=8000

spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

:four: resources/data.sql

```sql
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10001,'USD','INR',65,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10002,'EUR','INR',75,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10003,'AUD','INR',25,0);
```

:five: using h2 console (in-memory database)

JDBC URL: jdbc:h2:mem:testdb  
:arrow_forward: http://localhost:8000/h2-console  
[:framed_picture: h2 console](img/1-h2.png)
[:framed_picture: exchange value](img/2-exc-val.png)

:label: _Create a JPA Repository_

:one: create jpa repository

```java
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
   ExchangeValue findByFromAndTo(String from, String to);
}

@RestController
public class CurrencyExchangeController {
   @Autowired
   Environment environment;
   @Autowired
   ExchangeValueRepository repository;
   //jpa repository exchange value
   @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
   public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
      int port = Integer.parseInt(environment.getProperty("local.server.port"));
      ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
      exchangeValue.setPort(port);
      return exchangeValue;
   }
```

:arrow_forward: http://localhost:8000/currency-exchange/from/EUR/to/INR

```json
{
  "id": 10002,
  "from": "EUR",
  "to": "INR",
  "conversionMultiple": 75.0,
  "port": 8000
}
```
