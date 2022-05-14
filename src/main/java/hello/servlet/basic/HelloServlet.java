package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    
    //서블릿 호출시(urlPattern) service 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); //org.apache.catalina.connector.RequestFacade@7aa3142
        System.out.println("response = " + response); //org.apache.catalina.connector.ResponseFacade@290b21c9

        //queryString 조회
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //header정보에 넣기(response의 content-type)
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        
        //http message body에 데이터가 들어감 -> 화면에 hello + username 보여줌
        response.getWriter().write("hello " + username);
    }
}
