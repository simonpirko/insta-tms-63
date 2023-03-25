package by.tms.insta.service;

import by.tms.insta.entity.Comment;
import by.tms.insta.entity.Post;
import by.tms.insta.storage.JDBCCommentStorage;

import java.util.List;
import java.util.Optional;

public class CommentService {
    private static CommentService commentService;
    private final JDBCCommentStorage storage = JDBCCommentStorage.getInstance();

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

    public Optional<Comment> findCommentById(Comment comment){
        return storage.findById(comment.getId());
    }

    public List<Comment> findAllComments(){
        return storage.findAll();
    }

    public List<Comment> findAllCommentsByPostId(Post post){
        return storage.findAllCommentsByPostId(post.getId());
    }
}
