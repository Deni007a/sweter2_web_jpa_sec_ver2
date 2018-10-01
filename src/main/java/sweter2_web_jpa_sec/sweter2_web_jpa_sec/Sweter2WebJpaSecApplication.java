package sweter2_web_jpa_sec.sweter2_web_jpa_sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sweter2WebJpaSecApplication {

    public static void main(String[] args) {
        System.out.println("Start");

        SpringApplication.run(Sweter2WebJpaSecApplication.class, args);

        //http://localhost:8080/greeting?name=vvvv
    }
}
