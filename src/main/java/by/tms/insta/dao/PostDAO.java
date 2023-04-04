package by.tms.insta.dao;

import by.tms.insta.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostDAO extends DAO<Post> {
    List<Post> findPostsByUserId(long userid);
    Optional<Post> findPostWithComments(long postId);
}
