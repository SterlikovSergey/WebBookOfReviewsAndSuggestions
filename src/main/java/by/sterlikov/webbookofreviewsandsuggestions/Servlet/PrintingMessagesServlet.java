package by.sterlikov.webbookofreviewsandsuggestions.Servlet;

import by.sterlikov.webbookofreviewsandsuggestions.Service.UserService;
import by.sterlikov.webbookofreviewsandsuggestions.Service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/allMessages")
public class PrintingMessagesServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("messages",userService.printingAllUsers());
            req.getRequestDispatcher("allMessages.jsp").forward(req,resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
