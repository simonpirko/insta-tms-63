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
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet("/post/create")
public class CreatePostServlet extends HttpServlet {

    PostService postService = PostService.getInstance();
    UserService userService = UserService.getInstance();
    public final static String USER_ID = "user_id";
    public final static String DESCRIPTION = "post_description";
    public final static String URL = "post_url";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      long userId= Long.parseLong(req.getParameter(USER_ID));
        long userId = Long.parseLong((String) req.getSession().getAttribute(USER_ID));
        String description = req.getParameter(DESCRIPTION);
        String url = req.getParameter(URL);
        Optional<User> userById = userService.findUserById(userId);
        if (userById.isEmpty()) {

            //        resp.sendRedirect("/post.jsp"); todo add error pages

            throw new RuntimeException("User id is undefined");
        }

        Post createPost = Post.newBuilder()
                .setCreator(userById.get())
                .setDescription(description)
                .setUrl(url)
                .setCreateAt(LocalDateTime.now())
                .build();
        postService.createPost(createPost);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);

    }
}
