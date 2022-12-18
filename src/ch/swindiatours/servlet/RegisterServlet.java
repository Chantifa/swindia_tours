package ch.swindiatours.servlet;

import ch.swindiatours.connection.DbCon;
import ch.swindiatours.dao.UserDao;
import ch.swindiatours.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Objects;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        final String name = request.getParameter("name");
        final String email = request.getParameter("email");
        final String pwd = request.getParameter("password");
        final String repeadpwd = request.getParameter("repeatepassword");

        User user = new User();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("swindiatours");
        EntityManager em = emf.createEntityManager();
            UserDao userDao = new UserDao(em);

            user.setPassword(pwd);
            user.setName(name);
            user.setEmail(email);

            boolean result = userDao.userRegister(user);
            if (result) {
                response.sendRedirect("login.jsp");
            } else {
                out.println("register failed");
            }

        // Check if password repeat is correct
        if (!(name.isEmpty() || email.isEmpty() ||
                pwd.isEmpty() || repeadpwd.isEmpty())) {
            if (checkPassword(pwd, repeadpwd)) {

                final HttpSession session = request.getSession();

                session.setAttribute("customer", user);
            }

            if (name.isEmpty() || email.isEmpty() || pwd.isEmpty()) {
                request.getRequestDispatcher("register.jsp").include(request, response);
                out.print("<center><p>Please Enter Valid Details to Register</p></center>");
            } else {
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        }
    }

    /**
     * Check if both passwords are equal, if not deny registering
     *
     * @param pwd       the actual password
     * @param repeatPwd the repeated password
     * @return true if both are same, false if both don't match
     */
    private boolean checkPassword(String pwd, String repeatPwd) {
        if (pwd != null) {
            return Objects.equals(pwd, repeatPwd);
        }
        return false;
    }


}
