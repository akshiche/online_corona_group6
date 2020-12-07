package com.cg.onlinecorona;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Desc : Implemented logger and also main method to run the application
 * @author AKSHITHA
 *
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Logger logger=Logger.getLogger(Application.class);
		logger.info("Open");
	}

}
