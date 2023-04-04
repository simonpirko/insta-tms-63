package by.tms.insta.servlet;

import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/my-posts")
public class MyPostsServlet extends HttpServlet {
    private final PostService postService = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user");
        List<Post> posts = postService.findPostsByUserId(currentUser.getId());
        req.setAttribute("myPosts", posts);
        getServletContext().getRequestDispatcher("/pages/myPosts.jsp").forward(req,resp);
    }
}
