package by.tms.insta.web.servlet;

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
import java.util.List;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    private static final String BODY = "body";
    private static final String CURRENT_POST = "post";
    private static final String CURRENT_USER = "user";
    private static final String COMMENTS = "comments";
    private static final String MESSAGE = "message";
    private static final String NO_COMMENTS_MESSAGE = "no comments";
    private static final String COMMENT_PATH = "/pages/comment.jsp";
    private final CommentService commentService = CommentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(COMMENT_PATH);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getParameter(BODY);
        User currentUser = (User) req.getSession().getAttribute(CURRENT_USER);
        Post currentPost = (Post) req.getSession().getAttribute(CURRENT_POST);

        List<Comment> allCommentsByPostId = commentService.findAllCommentsByPostId(currentPost);
        if (allCommentsByPostId.isEmpty()) {
            req.setAttribute(MESSAGE, NO_COMMENTS_MESSAGE);
        } else {
            req.setAttribute(COMMENTS, allCommentsByPostId);
        }

        commentService.addComment(Comment.builder()
                .setBody(body)
                .setAuthor(currentUser)
                .setCreateAt(LocalDateTime.now())
                .setPost(currentPost)
                .build());
        resp.sendRedirect(COMMENT_PATH);
    }
}
