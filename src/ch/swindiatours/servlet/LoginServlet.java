package ch.swindiatours.servlet;

import ch.swindiatours.connection.DbCon;
import ch.swindiatours.dao.UserDao;
import ch.swindiatours.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("swindiatours");
            EntityManager em = emf.createEntityManager();
            UserDao udao = new UserDao(em);
            User user = udao.userLogin(email, password);
            if (user != null) {
                request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
                response.sendRedirect("index.jsp");
            } else {
                out.println("there is no user");
            }
        }
    }
}
