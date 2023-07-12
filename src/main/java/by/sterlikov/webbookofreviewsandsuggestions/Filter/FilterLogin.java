package by.sterlikov.webbookofreviewsandsuggestions.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebFilter(value = "/*")
public class FilterLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var path = ((HttpServletRequest) servletRequest).getServletPath();
        var login = ((HttpServletRequest) servletRequest).getSession().getAttribute("login");
        var currentLogin = servletRequest.getParameter("login");
        if("/".equals(path) || login != null){
            filterChain.doFilter(servletRequest,servletResponse);
        } else if (currentLogin != null){
            ((HttpServletRequest) servletRequest).getSession().setAttribute("login",currentLogin);
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest,servletResponse);
        }
    }
}
