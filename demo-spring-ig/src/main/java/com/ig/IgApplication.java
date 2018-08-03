package com.ig;

import cl.bci.integ.db.banele.convenios.configuration.SpBaneleConveniosClientConfiguration;
import cl.bci.integ.db.banele.enrolamiento.configuration.SpBaneleEnrolamientoClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		SpBaneleConveniosClientConfiguration.class,
		SpBaneleEnrolamientoClientConfiguration.class
})
public class IgApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgApplication.class, args);
	}
}
