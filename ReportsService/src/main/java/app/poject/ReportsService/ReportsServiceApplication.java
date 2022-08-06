package app.poject.ReportsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
public class ReportsServiceApplication {

	@RequestMapping("/")
	@ResponseBody
	public String home(HttpServletRequest request){
		StringBuilder builder=new StringBuilder();
		builder.append("<h1>Service Reports</h1>");

		return builder.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReportsServiceApplication.class, args);
	}

}
