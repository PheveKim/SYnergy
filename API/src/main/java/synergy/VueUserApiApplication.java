package synergy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class VueUserApiApplication{
	public static void main(String[] args) {
		SpringApplication.run(VueUserApiApplication.class, args);
	}

}
