package by.tms.insta.storage;

import by.tms.insta.entity.Comment;

import java.util.List;

public interface CommentStorage extends Storage<Comment> {
    List<Comment> findAllCommentsByUserId(long userId);
}