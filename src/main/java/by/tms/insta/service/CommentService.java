package by.tms.insta.service;

import by.tms.insta.entity.Comment;
import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCCommentStorage;

import java.util.List;
import java.util.Optional;

public class CommentService {
    private static CommentService commentService;
    private static final JDBCCommentStorage storage = JDBCCommentStorage.getInstance();

    private CommentService() {

    }

    public static CommentService getInstance() {
        if (commentService == null) {
            commentService = new CommentService();
        }
        return commentService;
    }

    public void addComment(Comment comment){
        storage.save(comment);
    }

    public void removeComment(Comment comment){
        storage.remove(comment.getId());
    }

    public Optional<Comment> findCommentById(Post post){
        return storage.findById(post.getId());
    }

    public List<Comment> findAllComments(){
        return storage.findAll();
    }

    public List<Comment> findAllCommentsByUserId(User user){
        return storage.findAllCommentsByUserId(user.getId());
    }
}
