package hello.servlet.web.frontController.v5;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v5.adapter.HandlerAdapterFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final HandlerAdapterFactory handlerAdapterFactory;

    public FrontControllerServletV5() {
        handlerAdapterFactory = new HandlerAdapterFactory();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Object handler = handlerAdapterFactory.getHandler(request.getRequestURI());
            MyHandlerAdapter adapter = handlerAdapterFactory.getAdapter(handler);

            ModelView mv = adapter.handle(request, response, handler);
            MyView view = viewResolver(mv.getViewName());

            view.render(mv.getModel(), request, response);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
