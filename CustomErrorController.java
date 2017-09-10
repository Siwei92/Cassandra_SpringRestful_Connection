package hello;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    String error(HttpServletRequest request, HttpServletResponse response) {
    	if(response.getStatus()==200){
    	  return " HTTP 200 OK";
    	}
        else if(response.getStatus()==400){
    	  return " HTTP 400 Bad Request:";
    	}
    	else if(response.getStatus()==500){
    		 return "HTTP 500 Internal Server Error";
    	}
    	else if(response.getStatus()==404){
   		 return "HTTP 404 Page not Found Error";
      	}
        return "Has a Error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}