package br.com.douglasffilho.uaa;

import br.com.douglasffilho.authorizationservice.AuthorizationServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {
                UaaApplication.class,
                AuthorizationServiceApplication.class
        }
)
public class UaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }

}
