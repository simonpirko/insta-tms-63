package by.tms.insta.dao;

import by.tms.insta.entity.Comment;

import java.util.List;

public interface CommentDAO extends DAO<Comment> {
    List<Comment> findAllCommentsByPostId(long postId);
}