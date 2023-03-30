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

@WebServlet("/edit-password")
public class EditePasswordServlet extends HttpServlet {
    private static final String OLD_PASSWORD = "oldPassword";
    private static final String NEW_PASSWORD = "newPassword";
    private static final String REPEATING_NEW_PASSWORD = "repeatingNewPassword";
    private static final String USER = "user";
    private static final String MESSAGE = "message";
    private static final String WRONG_PASSWORD_MESSAGE = "wrong password";
    private static final String SAVE_NEW_PASSWORD_MESSAGE = "save new password";
    private static final String PASSWORDS_ARE_NOT_EQUAL_MESSAGE = "passwords aren't equal";
    private static final String PASSWORD_IS_INVALID_MESSAGE = "password is invalid";
    private static final String EDITING_PASSWORD_PAGE_PATH = "/pages/editingPassword.jsp";
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(EDITING_PASSWORD_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter(OLD_PASSWORD);
        String newPassword = req.getParameter(NEW_PASSWORD);
        String repeatingNewPassword = req.getParameter(REPEATING_NEW_PASSWORD);
        User currentUser = (User) req.getSession().getAttribute(USER);
        if (currentUser.getPassword().equals(oldPassword)) {
            if (UserValidator.isPasswordValid(newPassword)) {
                if (newPassword.equals(repeatingNewPassword)) {
                    User user = userService.updatePasswordById(newPassword, currentUser.getId()).get();
                    req.getSession().setAttribute(USER, user);
                    req.setAttribute(MESSAGE, SAVE_NEW_PASSWORD_MESSAGE);
                } else {
                    req.setAttribute(MESSAGE, PASSWORDS_ARE_NOT_EQUAL_MESSAGE);
                }
            } else {
                req.setAttribute(MESSAGE, PASSWORD_IS_INVALID_MESSAGE);
            }
        } else {
            req.setAttribute(MESSAGE, WRONG_PASSWORD_MESSAGE);
        }
        getServletContext().getRequestDispatcher(EDITING_PASSWORD_PAGE_PATH).forward(req, resp);
    }
}
