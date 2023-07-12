package by.sterlikov.webbookofreviewsandsuggestions.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        if(login.isEmpty()) {
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        } else {
            req.getSession().setAttribute("name", req.getParameter("login"));
            req.getRequestDispatcher("addMessage.jsp").forward(req, resp);
        }
        System.out.println(login);
    }
}
