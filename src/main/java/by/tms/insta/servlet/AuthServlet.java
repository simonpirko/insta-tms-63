package by.tms.insta.servlet;

import by.tms.insta.entity.User;
import by.tms.insta.service.UserService;
import by.tms.insta.validators.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final String USER = "user";
    private static final String EMAIL = "email";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private static final String AUTH_PATH = "/pages/auth.jsp";
    private static final String PROFILE_PATH = "/pages/profile.jsp";
    private static final String WRONG_PASSWORD_MESSAGE = "Wrong password!";
    private static final String USER_NOT_FOUND_MESSAGE = "User not found!";
    private static final String INVALID_INFO_MESSAGE = "invalid information";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(AUTH_PATH);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter(EMAIL);
        String username = req.getParameter(USERNAME);
        String password = req.getParameter(PASSWORD);
        if (UserValidator.isValid(User.newBuilder().setUsername(username).setPassword(password).setEmail(email).build())) {
            Optional<User> byUsername = UserService.getInstance().findUserByUserName(username);
            if (byUsername.isPresent()) {
                User user = byUsername.get();
                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute(USER, user);
                    req.setAttribute(USERNAME, username);
                    req.setAttribute(PASSWORD, password);
                    resp.sendRedirect(PROFILE_PATH);
                } else {
                    req.setAttribute(MESSAGE, WRONG_PASSWORD_MESSAGE);
                }
            } else {
                req.setAttribute(MESSAGE, USER_NOT_FOUND_MESSAGE);
            }
        } else {
            req.setAttribute(MESSAGE, INVALID_INFO_MESSAGE);
        }
        getServletContext().getRequestDispatcher(AUTH_PATH).forward(req, resp);
    }
}
