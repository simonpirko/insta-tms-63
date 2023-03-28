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

@WebServlet("/editePersonalInfo")
public class EditPersonalInfoServlet extends HttpServlet {
    private User currentUser = null;
    private final UserService userService = UserService.getInstance();
    private static final String USER = "user";
    private static final String EMAIL = "email";
    private static final String FULL_NAME = "fullName";
    private static final String AVATAR = "avatar";
    private static final String MESSAGE = "message";
    private static final String SAVE_NEW_PERSONAL_INFO_MESSAGE = "save new personal information";
    private static final String EDITING_PERSONAL_INFO_PAGE_PATH = "/pages/editingPersonalInfo.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentUser = (User) req.getSession().getAttribute(USER);
        req.setAttribute(EMAIL, currentUser.getEmail());
        req.setAttribute(FULL_NAME, currentUser.getFullName());
        req.setAttribute(AVATAR, currentUser.getAvatar());
        getServletContext().getRequestDispatcher(EDITING_PERSONAL_INFO_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentUser = (User) req.getSession().getAttribute(USER);
        String email = req.getParameter(EMAIL);
        String fullName = req.getParameter(FULL_NAME);
        String avatar = req.getParameter(AVATAR);
        User updatedUser = userService.changeEmailFullNameAvatarById(User.builder()
                        .setId(currentUser.getId())
                        .setEmail(email)
                        .setFullName(fullName)
                        .setAvatar(avatar)
                        .setUpdateAt(LocalDateTime.now())
                        .build()).get();
        req.getSession().setAttribute(USER, updatedUser);
        req.setAttribute(EMAIL, updatedUser.getEmail());
        req.setAttribute(FULL_NAME, updatedUser.getFullName());
        req.setAttribute(AVATAR, updatedUser.getAvatar());
        req.setAttribute(MESSAGE, SAVE_NEW_PERSONAL_INFO_MESSAGE);
        getServletContext().getRequestDispatcher(EDITING_PERSONAL_INFO_PAGE_PATH).forward(req, resp);
    }
}
