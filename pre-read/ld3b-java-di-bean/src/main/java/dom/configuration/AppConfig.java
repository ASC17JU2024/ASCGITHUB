
package dom.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dom.repository.ProductRepository;
import dom.repository.ProductRepositoryImpl;
import dom.service.ProductService;
import dom.service.ProductServiceImpl;

//Indicates that a class declares one or more @Bean methods and 
//may be processed by the Spring container to generate bean definitions and 
//service requests for those beans at runtime
@Configuration
@ComponentScan("dom")
public class AppConfig {
// Legacy configuration	
//	<bean id="productRepository"
//			class="dom.repository.ProductRepositoryImpl" />
//
//		<!-- constructor based di -->
//		<!-- <bean id="productService" class="dom.service.ProductServiceImpl"> <constructor-arg 
//			index="0" ref="productRepository"/> <constructor-arg ref="productRepository" 
//			/> </bean> -->
	@Bean
	public ProductRepository productRepository() {
		return new ProductRepositoryImpl();
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl(productRepository());
	}
}
