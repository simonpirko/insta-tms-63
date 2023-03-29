package by.tms.insta.servlet;

import by.tms.insta.entity.Like;
import by.tms.insta.service.LikeService;
import by.tms.insta.service.UserService;

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
        String post = req.getParameter("post.id");
        long userId = Long.parseLong((String) req.getSession().getAttribute("user.id"));
        long likeId = Long.parseLong((String) req.getSession().getAttribute("like.id"));
        Optional<Like> likeByUserId = likeService.findLikeByUserId(userId);
        if (likeByUserId.isEmpty()) {
            likeService.deleteLike(userId);
        }

        Like saveLike = Like.builder()
                .setId(likeId)
                .setAuthor(likeByUserId.get().getAuthor())
                .setPost(Long.parseLong(post))
                .build();
        likeService.saveLike(saveLike);
    }

}
