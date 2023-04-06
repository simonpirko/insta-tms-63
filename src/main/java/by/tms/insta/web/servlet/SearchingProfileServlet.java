package by.tms.insta.web.servlet;

import by.tms.insta.entity.User;
import by.tms.insta.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/searching-profile")
public class SearchingProfileServlet extends HttpServlet {
    private static final String PROFILE_PATH = "/pages/profile.jsp";
    private final UserService userService = UserService.getInstance();
    private static final String USERNAME = "username";
    private static final String USER = "user";
    private static final String MESSAGE = "message";
    private static final String POSTS = "posts";
    private static final String USER_NOT_FOND_MESSAGE = "No results found for ";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME);
        Optional<User> userWithPosts = userService.getUserWithPosts(username);
        if (userWithPosts.isPresent()) {
            req.setAttribute(USER, userWithPosts.get());
            req.setAttribute(POSTS, userWithPosts.get().getPosts());
        } else {
            req.setAttribute(MESSAGE, USER_NOT_FOND_MESSAGE+username);
        }
        getServletContext().getRequestDispatcher(PROFILE_PATH).forward(req, resp);
    }
}
