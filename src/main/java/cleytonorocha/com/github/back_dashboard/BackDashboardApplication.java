package cleytonorocha.com.github.back_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class BackDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackDashboardApplication.class, args);
	}

}
