package by.tms.insta.servlet;

import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.service.PostService;
import by.tms.insta.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/searching-profile")
public class SearchingProfileServlet extends HttpServlet {
    private static final String PROFILE_PATH = "/pages/profile.jsp";
    private final UserService userService = UserService.getInstance();
    private final PostService postService = PostService.getInstance();
    private static final String USERNAME = "username";
    private static final String USER = "user";
    private static final String MESSAGE = "message";
    private static final String POSTS = "posts";
    private static final String USER_NOT_FOND_MESSAGE = "user not found";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME);
        Optional<User> byUserName = userService.findByUserName(username);
        if (byUserName.isPresent()) {
            List<Post> posts = postService.findPosts(byUserName.get().getId());
            req.setAttribute(USER, byUserName.get());
            req.setAttribute(POSTS, posts);
        } else {
            req.setAttribute(MESSAGE, USER_NOT_FOND_MESSAGE);
        }
        getServletContext().getRequestDispatcher(PROFILE_PATH).forward(req, resp);
    }
}
