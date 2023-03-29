package by.tms.insta.storage;

import by.tms.insta.entity.Like;

import java.util.List;
import java.util.Optional;

public interface LikesStorage extends Storage<Like>{
    Optional<Like> findLikeByUserId(long userid);
    List<Like> findLikeByPost(long post);
}
