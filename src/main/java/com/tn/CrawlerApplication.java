package com.tn;

import com.tn.web.po.Gamble;
import com.tn.web.repository.GambleRepository;
import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SocketUtils;

import java.util.Date;

@SpringBootApplication
public class CrawlerApplication {
	private static final Logger log = LoggerFactory.getLogger(CrawlerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);
	}
//	@Bean
//	public Integer port() {
//		return SocketUtils.findAvailableTcpPort();
//	}
//
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//		return tomcat;
//	}
//
//	private Connector createStandardConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setPort(port());
//		return connector;
//	}

//	@Bean
//	public CommandLineRunner run(GambleRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			Gamble gamble=new Gamble();
//			gamble.setCreator("tommy");
//			gamble.setStartTime(new Date());
//			repository.save(gamble);
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Gamble customer : repository.findAll()) {
//				log.info(customer.getCreator());
//			}
//			log.info("");
//
//		};
//	}

}
