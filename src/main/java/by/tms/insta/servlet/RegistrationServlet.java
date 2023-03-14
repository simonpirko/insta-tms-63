package by.tms.insta.servlet;


import by.tms.insta.entity.User;
import by.tms.insta.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {

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
        Optional<User> byUsername = UserService.getInstance().findUser(username);
        if (byUsername.isEmpty()) {
            UserService.getInstance().createAccount(new User(fullName, email, username, password));
            resp.sendRedirect("/auth");
            return;
        } else {
            req.setAttribute("message", "Registration failed. Check the correctness of the entered data!");
        }
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);

    }

}


