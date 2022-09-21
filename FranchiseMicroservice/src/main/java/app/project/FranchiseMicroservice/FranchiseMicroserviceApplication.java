package app.project.FranchiseMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@Controller
public class FranchiseMicroserviceApplication {

	@RequestMapping("/")
	@ResponseBody
	public String home(HttpServletRequest request){
		StringBuilder builder=new StringBuilder();
		builder.append("<h1>Service Franchise</h1>");

		return builder.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(FranchiseMicroserviceApplication.class, args);
	}

}
