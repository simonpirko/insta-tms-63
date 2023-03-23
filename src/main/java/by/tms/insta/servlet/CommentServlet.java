package by.tms.insta.servlet;

import by.tms.insta.entity.Comment;
import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    private static final String BODY = "body";
    private static final String CURRENT_POST = "post";
    private static final String CURRENT_USER = "user";
    private static final CommentService commentService = CommentService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getParameter(BODY);
        Post currentPost = (Post) req.getSession().getAttribute(CURRENT_POST);
        User currentUser = (User) req.getSession().getAttribute(CURRENT_USER);
        commentService.addComment(Comment.builder()
                .setBody(body)
                .setAuthor(currentUser)
                .setCreateAt(LocalDateTime.now())
                .setPost(currentPost)
                .build());
        resp.sendRedirect("/page/post.jsp");

    }
}
