package by.tms.insta.web.servlet;

import by.tms.insta.entity.Like;
import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.service.LikeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/post/like")
public class LikesServlet extends HttpServlet {
    LikeService likeService = LikeService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Post post = (Post) req.getSession().getAttribute("post.id");
        User userId = (User) req.getSession().getAttribute("user.id");
        long likeId = Long.parseLong((String) req.getSession().getAttribute("like.id"));
        Optional<Like> likeByUserId = likeService.findLikeByUserId(userId.getId());
        if (likeByUserId.isEmpty()) {
            likeService.deleteLike(userId.getId());
        }

        Like saveLike = Like.builder()
                .setId(likeId)
                .setAuthor(userId)
                .setPost(post)
                .build();
        likeService.saveLike(saveLike);
    }

}