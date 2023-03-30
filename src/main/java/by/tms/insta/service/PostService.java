package by.tms.insta.service;

import by.tms.insta.entity.Comment;
import by.tms.insta.entity.Post;
import by.tms.insta.dao.JDBCPostDAO;
import by.tms.insta.dao.PostDAO;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostDAO postDAO = JDBCPostDAO.getInstance();
    private final CommentService commentService = CommentService.getInstance();
    private static PostService instance;

    private PostService() {

    }

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    public Optional<Post> findPostById(long id) {
        return postDAO.findById(id);
    }

    public List<Post> findAllPosts() {
        return postDAO.findAll();
    }

    public void removePost(long id) {
        postDAO.remove(id);
    }

    public List<Post> findPosts(long id) {
        return postDAO.findPostsByUserId(id);
    }

    public void createPost(Post post) {
        postDAO.save(post);
    }

    public List<Comment> getPostWithComments(Post post){
        return commentService.findAllCommentsByPostId(post);
    }
}
