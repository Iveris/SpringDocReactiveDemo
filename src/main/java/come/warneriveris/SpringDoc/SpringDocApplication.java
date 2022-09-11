package come.warneriveris.SpringDoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "The Albums API", version = "v1"),
        servers = @Server(url = "/Albums-Api")
)
public class SpringDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDocApplication.class, args);
	}

}
