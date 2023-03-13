package by.tms.insta.servlet;

import by.tms.insta.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> byUsername = userService.findUser(username);
        if (byUsername.isEmpty()) {
            userService.createAccount(new User(fullName, username, email, password));
            resp.sendRedirect("/auth");
            return;
        }
        if (byUsername.isPresent()) {
            req.setAttribute("message", "Registration failed. Check the correctness of the entered data!");
        } else {
            req.setAttribute("message", "Registration failed. Check the correctness of the entered data!");
        }

    }
}
