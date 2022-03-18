package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] start");
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> System.out.println("parameterName : " + request.getParameter(parameterName)));
        System.out.println("[전체 파라미터 조회] end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] start");
        String username = request.getParameter("username");
        System.out.println("username : " + username);
        System.out.println("[단일 파라미터 조회] end");
        System.out.println();

        System.out.println("[중복 파라미터 조회] start");
        String[] name = request.getParameterValues("username");
        for (String s : name) {
            System.out.println("username : " + s);
        }

        System.out.println("[중복 파라미터 조회] end");
    }
}
