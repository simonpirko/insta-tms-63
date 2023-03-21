package by.tms.insta.storage;

import by.tms.insta.entity.Post;

import java.util.List;

public interface PostStorage extends Storage<Post> {
    List<Post> findPostsByUserId(long userid);
}
