package ar.com.educacionit.movie.swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {

	//leer las variables
	@Value("${openapi.dev-url}")
	private String devUrl;
	
	@Value("${openapi.prod-url}")
	private String prodUrl;
	
	@Bean
	public OpenAPI myOpenApi() {
		Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("contact@educacionit.com");
        contact.setName("carlos lopez");
        contact.setUrl("https://www.educationit.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Movies Service API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Movies.")
                .termsOfService("https://www.educationit.com")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}
}
