package su.um.feri.zimskasola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ZimskasolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZimskasolaApplication.class, args);
	}

}
