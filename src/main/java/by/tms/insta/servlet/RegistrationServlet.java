package by.tms.insta.servlet;


import by.tms.insta.entity.User;
import by.tms.insta.service.UserService;
import by.tms.insta.validators.UserValidator;

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
    private static final String AVATAR = "avatar";
    private static final String EMAIL = "email";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private static final String FULL_NAME = "fullName";
    private static final String REG_PATH = "/pages/register.jsp";
    private static final String AUTH_PATH = "/auth";
    private static final String USER_ALREADY_EXISTS = "The user already exists!!!";
    private static final String REGISTRATION_FAILED = "Registration failed. Check the correctness of the entered data!";

    private final UserService userService = UserService.getInstance();
    private final UserValidator userValidator = new UserValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(REG_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter(FULL_NAME);
        String username = req.getParameter(USERNAME);
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        String avatar = req.getParameter(AVATAR);
        Optional<User> byUsername = userService.findUserByUserName(username);
        if (byUsername.isEmpty()) {
            userService.createAccount(User.builder()
                    .setUsername(username)
                    .setPassword(password)
                    .setEmail(email)
                    .setFullName(fullName)
                    .setCreateAt(LocalDateTime.now())
                    .setUpdateAt(LocalDateTime.now())
                    .setAvatar(avatar)
                    .build());
            resp.sendRedirect(AUTH_PATH);
            return;
        }
        if (byUsername.isPresent()) {
            req.setAttribute(MESSAGE, USER_ALREADY_EXISTS);
        } else {
            req.setAttribute(MESSAGE, REGISTRATION_FAILED);
        }
        getServletContext().getRequestDispatcher(REG_PATH).forward(req, resp);

    }

}


