package ch.swindiatours.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="register", value="/register")
public class RegisterServlet {
    private static final long serialVersionUID =1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br>Please register here");
        out.println("email: "+email);
        out.println("password: "+ password);
        out.println("</body>");
        out.println("</html>");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
