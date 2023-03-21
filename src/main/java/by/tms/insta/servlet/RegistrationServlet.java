package by.tms.insta.servlet;


import by.tms.insta.entity.User;
import by.tms.insta.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String avatar = req.getParameter("avatar");
        Optional<User> byUsername = userService.findUserByUserName(username);
        if (byUsername.isEmpty()) {
            userService.createAccount(User.newBuilder()
                    .setFullName(fullName)
                    .setEmail(email)
                    .setUsername(username)
                    .setPassword(password)
                    .setCreateAt(LocalDateTime.now())
                    .setUpdateAt(LocalDateTime.now())
                    .setAvatar(avatar)
                    .build());
            resp.sendRedirect("/auth");
            return;
        }
        if (byUsername.isPresent()) {
            req.setAttribute("message", "The user already exists.");
        } else {
            req.setAttribute("message", "Registration failed. Check the correctness of the entered data!");
        }
        getServletContext().getRequestDispatcher("/pages/register.jsp").forward(req, resp);

    }

}


