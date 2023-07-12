package by.sterlikov.webbookofreviewsandsuggestions.Servlet;

import java.io.*;

import by.sterlikov.webbookofreviewsandsuggestions.Model.User;
import by.sterlikov.webbookofreviewsandsuggestions.Service.UserService;
import by.sterlikov.webbookofreviewsandsuggestions.Service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "MessageServlet", value = "/messages")
public class MessageServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getSession().getAttribute("name");
        var eMail = req.getParameter("eMail");
        var message = req.getParameter("message");

        User newUser = new User((String) login,eMail,message);
        if(newUser.getLogin().isEmpty()){
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        } else if ( newUser.getEMail().isEmpty() || newUser.getMessage().isEmpty()) {
            req.getRequestDispatcher("addMessage.jsp").forward(req, resp);
        }else {
            try {
                userService.addUser(newUser);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.getRequestDispatcher("success.jsp").forward(req, resp);
            try {
                req.setAttribute("messages",userService.printingAllUsers());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void destroy() {
    }
}