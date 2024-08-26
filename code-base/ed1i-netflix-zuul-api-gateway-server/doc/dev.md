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

:newspaper: **ed1f-currency-conversion-service-feign Connect Limits Service to Spring Cloud
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

:two: ed1f-currency-conversion-service-feign bootstrap.properties

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

:newspaper: **ed1f-currency-conversion-service-feign** ..

:beginner: _hard coded currency
exchange service_

:one: ed1f-currency-conversion-service-feign\src\main\resources\application.properties

```properties
spring.application.name=currency-exchange-service
server.port=8000
```

:two: ed1f-currency-conversion-service-feign mdl\ExchangeValue.java

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

:beginner: _Dynamic Port in the the
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

:beginner: _virtual machine arguments_

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

:beginner: _Configure JPA and Initialized Data_

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

:beginner: _Create a JPA Repository_

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

---

:newspaper: **ed1f-currency-conversion-service-feign create Feign REST
Client for Service Invocation** ..

:beginner: **feign dependency**

```xml
      <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-openfeign</artifactId>
      </dependency>
```

:beginner: **feign proxy**

```java
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
   @GetMapping("/currency-exchange/from/{from}/to/{to}")
   CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
                                            @PathVariable("to") String to);
}
```

:beginner: **using proxy**

```java
@RestController
public class CurrencyConversionController {
   @Autowired
   private CurrencyExchangeServiceProxy proxy;

   //using FeignClient & Proxy
   @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
   public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                             @PathVariable BigDecimal quantity) {
      py("feign cleint");
      CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }
```

:beginner: **enable feign proxy**

```java
@SpringBootApplication
@EnableFeignClients("xpl.pxy")
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
      pp("ed1g-currency-conversion-service-ribbon");
   }
}
```

:arrow_forward: http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "quantity": 1000,
  "totalCalculatedAmount": 65000.0,
  "port": 8000
}
```

---

:newspaper: **ed1f-currency-conversion-service-ribbon client side load balancing
with Ribbon** ..

:beginner: **dependencies**

```xml
      <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
      </dependency>
```

:beginner: **application.properties**

```properties
spring.application.name=currency-conversion-service
server.port=8100
currency-exchange-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001
```

:beginner: **proxy**

```java
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
   @GetMapping("/currency-exchange/from/{from}/to/{to}")
   CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
                                            @PathVariable("to") String to);
}
```

:arrow_forward: http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000 (run twice to verify load balancing)

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "quantity": 1000,
  "totalCalculatedAmount": 65000.0,
  "port": 8000
}
```

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "quantity": 1000,
  "totalCalculatedAmount": 65000.0,
  "port": 8001
}
```

---

:newspaper: **ed1h-netflix-eureka-naming-server Eureka Naming Server** ..  
:beginner: **pom.xml**

```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

:beginner: **application.properties**

```properties
spring.application.name=netflix-eureka-naming-server
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

:beginner: **app**

```java
@EnableEurekaServer
public class App {
   public static void main(String[] args) {
```

:arrow_forward: http://localhost:8761/

:page*with_curl: \_\_ed1g-currency-conversion-service-ribbon Connecting Currency Conversion
Microservice to Eureka* ...

:beginner: **pom.xml**

```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

:beginner: **application.properties**

```properties
spring.application.name=currency-conversion-service
server.port=8100
currency-exchange-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```

:beginner: **app**

```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("xpl.pxy")
public class App {
```

---

:page*with_curl: \_ed1d-currency-exchange-service Connecting Currency Exchange
Microservice to Eureka* ...

:beginner: **pom.xml**

```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

:beginner: **application.properties**

```properties
spring.application.name=currency-exchange-service
server.port=8000
spring.jpa.show-sql=true
spring.h2.console.enabled=true
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```

:beginner: **app**

```java
@SpringBootApplication
@EnableDiscoveryClient
public class App {
```

:arrow_forward: [:framed_picture: run eureka, exchange (2 instances), conversion](img/3-eur-apps.png)  
:arrow_forward:
[:framed_picture:eureka dashboard ](img/4-eur-dash-1.png)

---

:page*with_curl: \_\_ed1d-currency-exchange-service Distributing calls using Eureka and
Ribbon* ...

:beginner: **application.properties**

```properties
#The exchange-service instances are obtained through eureka server
#currency-exchange-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001
```

:arrow_forward: http://localhost:8100/currency-converter/from/USD/to/INR/quantity/1000  
:point_right: currency exchange 8000,8001,8002

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "quantity": 1000,
  "totalCalculatedAmount": 65000.0,
  "port": 8000
}
```

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "quantity": 1000,
  "totalCalculatedAmount": 65000.0,
  "port": 8001
}
```

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "quantity": 1000,
  "totalCalculatedAmount": 65000.0,
  "port": 8002
}
```

---

:newspaper: **ed1i-netflix-zuul-api-gateway-server Implementing Zuul API Gateway** ..  
:one: pom.xml

```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```

:two: application.properties

```properties
spring.application.name=netflix-zuul-api-gateway-server
server.port=8765
```

:three: app

```java
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class App {
```

:four: Implementing Zuul Filter

```java
@Component
public class ZuulLoggingFilter extends ZuulFilter {
   private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public String filterType() {
      return "pre";
   }

   @Override
   public int filterOrder() {
      return 1;
   }

   @Override
   public boolean shouldFilter() {
      return true;
   }

   @Override
   public Object run() throws ZuulException {
      HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
      logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
      pb(request + " => " + request.getRequestURI());
      return null;
   }
}
```

:arrow_forward: http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 65.0,
  "port": 8002
}
```
----------

:beginner: **CurrencyExchangeServiceProxy setting up proxy to use zuul**   
:one: configure feign client to use zuul api gateway  
 
```java
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
   @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
   CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
                                            @PathVariable("to") String to);
}
```
:two: ed1i-netflix-zuul-api-gateway-server application.properties

```properties
spring.application.name=netflix-zuul-api-gateway-server
server.port=8765
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```
:three: controller
```java
@RestController
public class CurrencyConversionController {
   @Autowired
   private CurrencyExchangeServiceProxy proxy;

   //using FeignClient & Proxy & Zuul Api Gateway
   @GetMapping(
           value = "/currency-conversion-service/currency-converter/from/{from}/to/{to}/quantity" +
                   "/{quantity}")
   public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                             @PathVariable BigDecimal quantity) {
      py("feign+ ribbon cleint using zuul gateway api");
      CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }
```
:arrow_forward: http://localhost:8100/currency-conversion-service/currency-converter/from/USD/to/INR/quantity/10000  
:arrow_forward: http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR  
  
```json
{
    "id": 10001,
    "from": "USD",
    "to": "INR",
    "conversionMultiple": 65.00,
    "quantity": 1000,
    "totalCalculatedAmount": 65000.00,
    "port": 8001
}
```
:arrow_forward: [:framed_picture: run zuul + apps](img/5-apps-zuul.png)  
:arrow_forward:
[:framed_picture:eureka dashboard ](img/6-eur-dash.png)

:beginner: **hitting CurrencyConversionController using zuul api gateway directly**  

```java
@RestController
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-conversion-service")
public class CurrencyConversionController {
   @Autowired
   private CurrencyExchangeServiceProxy proxy;

   @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity" + "/{quantity}")
   public CurrencyConversion convertCurrency1(@PathVariable String from, @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
      py("accessing conversion service through zuul gateway api");
      CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }
```
:arrow_forward: http://localhost:8765/currency-conversion-service/currency-converter/from/USD/to/INR/quantity/1000
  
```json
{
    "id": 10001,
    "from": "USD",
    "to": "INR",
    "conversionMultiple": 65.00,
    "quantity": 1000,
    "totalCalculatedAmount": 65000.00,
    "port": 8001
}
```
----------
:newspaper: **Implementing distributed tracing with Spring
Cloud Sleuth** ..  

:one: add sleuth dependency & logger.warn() to
- ed1d-currency-exchange-service, 
- ed1g-currency-conversion-service-ribbon, 
- ed1i-netflix-zuul-api-gateway-server
```xml
      <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-sleuth</artifactId>
      </dependency>
      <dependency>
         <groupId>io.zipkin.brave</groupId>
         <artifactId>brave</artifactId>
         <version>5.10.1</version>
         <scope>compile</scope>
      </dependency>
```
```java
   @Bean
   public Sampler defaultSampler() {
      return Sampler.ALWAYS_SAMPLE;
   }
```
:arrow_forward: [:framed_picture: run sleuth](img/7-apps-sleuth.png)  
:arrow_forward:
[:framed_picture:sleuth log ](img/8-sleuth-log.png)  

:newspaper: **Distributed Tracing with Zipkin** ..  

:one:  Erlang/OTP Installation  
:link:https://www.erlang.org/downloads  
:link:http://erlang.org/download/otp_win64_22.3.exe  

:two: RabbitMQ Installation  
:link: https://www.rabbitmq.com/install-windows.html#installer  
:link: https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.3/rabbitmq-server-3.8.3.exe  
 
:three: zipkin server  
:link: https://zipkin.io/pages/quickstart  
:link: https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec  

:arrow_forward: zipkin server  
 
```sh
set RABBIT_URI=amqp://localhost  
java -jar zipkin-server-2.21.1-exec.jar
```
:arrow_forward: http://localhost:9411/zipkin/  

:four: zipkin and rabbit mq  

:point_right: Spring Boot Release >= 2.1.*
- ed1d-currency-exchange-service, 
- ed1g-currency-conversion-service-ribbon, 
- ed1i-netflix-zuul-api-gateway-server
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit</artifactId>
		</dependency>
``` 
:point_right: Spring Boot Release < 2.1.*
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-sleuth-zipkin</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bus-amqp</artifactId>
		</dependency>
```
:arrow_forward: [:framed_picture: run zipkin](img/9-apps-zipkin.png)  
:arrow_forward:
[:framed_picture:zipkin log ](img/10-zipkin-log.png)  
:arrow_forward: [:framed_picture:zipkin log 1 ](img/10-zipkin-log1.png)  

----------

:newspaper: **Spring Cloud Bus** ..  
:one: ed1a-limits-service-1   
```xml
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-actuator</artifactId>
      </dependency>
```
:two:  run config-server, limits-service  
:arrow_forward: ed1b-spring-cloud-config-server :8888  
:arrow_forward: ed1a-limits-service-1 :8080   
:arrow_forward: ed1a-limits-service-1 :8081  

http://localhost:8080/limits  
http://localhost:8081/limits
```json
{
    "maximum": 888,
    "minimum": 8
}
```
:three: ed1c-git-localconfig-repo limits-service.properties  
```properties
#limits-service.minimum=8
limits-service.minimum=0
limits-service.maximum=888
```
:bell: git commit (works without it as well)  

:arrow_forward: http://localhost:8080/application/refresh    
```json
{
    "timestamp": "2020-05-11T15:33:55.453+0000",
    "status": 404,
    "error": "Not Found",
    "message": "No message available",
    "path": "/application/refresh"
}
```
:four: configure endpoints and security  
- ed1c-git-localconfig-repo limits-service.properties
```properties
#limits-service.minimum=8
limits-service.minimum=0
limits-service.maximum=888
management.endpoints.web.exposure.include=*
management.security.enabled=false
```
- ed1a-limits-service-1 bootstrap.properties
```properties
# fetch configuration information from config server
# overrides settings in application.properties
spring.application.name=limits-service
spring.cloud.config.uri=http://localhost:8888
#spring.profiles.active=dev
#spring.profiles.active=qa
management.endpoints.web.exposure.include=*
```

:bell: /actuator/refresh for Spring 2 and greater  

:arrow_forward: http://localhost:8081/actuator/refresh
```json
[
    "limits-service.minimum"
]
```
  
- run config-server  
:arrow_forward: ed1b-spring-cloud-config-server :8888   

:arrow_forward: http://localhost:8081/limits
```json
{
    "maximum": 888,
    "minimum": 0
}
``` 
:five: Implementing cloud bus  
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bus-amqp</artifactId>
		</dependency>
```
:arrow_forward: http://localhost:8080/actuator/bus-refresh  
:bell: 8080/actuator/bus-refresh for Spring 2 and greater  
:bell: 8080/bus/refresh for < Spring 2.

----------
:newspaper: **ed1a-limits-service-1 Fault Tolerance with Hystrix** ..  
:one: pom.xml  

```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
		</dependency>
```
:two: app
```java
@SpringBootApplication
@EnableHystrix
public class App {
```
:three: LimitsConfigurationController  
```java
@RestController
public class LimitsConfigurationController {
   @Autowired
   Configuration configuration;

   @GetMapping("/fault-tolerance-example")
   @HystrixCommand(defaultFallback = "fallbackRetrieveConfiguration")
   public LimitConfiguration retrieveConfiguration() {
      throw new RuntimeException("Not available");
   }

   public LimitConfiguration fallbackRetrieveConfiguration() {
      return new LimitConfiguration(999, 9);
   }
```

:arrow_forward: http://localhost:8080//fault-tolerance-example  
```json
{
    "maximum": 999,
    "minimum": 9
}
```

----------

:tada::tada::tada::tada::tada::tada::tada::tada::tada::tada::tada:   
