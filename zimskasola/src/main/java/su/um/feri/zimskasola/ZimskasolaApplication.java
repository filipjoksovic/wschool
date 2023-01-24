package su.um.feri.zimskasola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ZimskasolaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZimskasolaApplication.class, args);
    }

}
