package fi.alforza.location;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationRestapiApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LocationRestapiApplication.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
	}

}
