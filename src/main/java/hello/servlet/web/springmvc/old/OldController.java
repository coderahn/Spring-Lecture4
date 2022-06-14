package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller 이전에 사용한 Controller 인터페이스
//@Component : 스프링 빈 이름을 URL로 맞추어 사용 가능
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        //뷰리졸버를 만들어주자 -> application.properties
        return new ModelAndView("new-form");
    }
}
