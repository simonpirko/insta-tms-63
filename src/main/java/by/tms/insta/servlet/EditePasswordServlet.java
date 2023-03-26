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

@WebServlet("/editPassword")
public class EditePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/pages/editingPassword.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String repeatingNewPassword = req.getParameter("repeatingNewPassword");
        User currentUser = (User) req.getSession().getAttribute("user");
        if (currentUser.getPassword().equals(oldPassword)) {
            if (UserValidator.isPasswordValid(newPassword)) {
                if (newPassword.equals(repeatingNewPassword)) {
                    Optional<User> user = UserService.getInstance()
                            .changePasswordById(User.builder()
                                    .setId(currentUser.getId())
                                    .setPassword(newPassword)
                                    .setUpdateAt(LocalDateTime.now())
                                    .build());
                    req.getSession().setAttribute("user", user);
                    req.setAttribute("message", "save correctly");
                } else {
                    req.setAttribute("message", "not equals");
                }
            } else {
                req.setAttribute("message", "is invalid");
            }
        } else {
            req.setAttribute("message", "wrong password");
        }
        getServletContext().getRequestDispatcher("/pages/editingPassword.jsp").forward(req, resp);
    }
}
