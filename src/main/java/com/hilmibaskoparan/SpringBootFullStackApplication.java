package com.hilmibaskoparan;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

// Mongo Aktif Etmek icin
// @EnableMongoRepositories

// Aspect Aktif Etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
// @EntityScan(basePackages = "com.hilmibaskoparan.data.entity") //Entity bulamadığı zaman
// @EnableJpaRepositories(basePackages = "com.hilmibaskoparan.data.repository") //Repository bulamadığı zaman

// Spring Cache aktif etmek gerekiyor
// @EnableCaching

// auditorAware icin
//@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")

@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

//@SpringBootApplication
public class SpringBootFullStackApplication {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {

		// devtools active isActive
		// System.setProperty("spring.devtools.restart.enabled","true");

		// PORT Ayarlamak
        /*
        SpringApplication app = new SpringApplication(AnkaraUniversitySpringAllInOneApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
         */

		//Disables headless JOptionPane
		System.setProperty("java.awt.headless", "false");

		SpringApplication.run(SpringBootFullStackApplication.class, args);
	}

}
