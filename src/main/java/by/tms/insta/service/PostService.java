package by.tms.insta.service;

import by.tms.insta.entity.Comment;
import by.tms.insta.entity.Post;
import by.tms.insta.dao.JDBCPostDAO;
import by.tms.insta.dao.PostDAO;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostDAO postStorage = JDBCPostDAO.getInstance();
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
        return postStorage.findById(id);
    }

    public List<Post> findAllPosts() {
        return postStorage.findAll();
    }

    public void removePost(long id) {
        postStorage.remove(id);
    }

    public List<Post> findPosts(long id) {
        return postStorage.findPostsByUserId(id);
    }

    public void createPost(Post post) {
        postStorage.save(post);
    }

    public List<Comment> getPostWithComments(Post post){
        return commentService.findAllCommentsByPostId(post);
    }
}
