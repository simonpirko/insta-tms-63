package by.tms.insta.storage;

import by.tms.insta.entity.Post;

public interface PostStorage extends Storage<Post>{
    void removeByUserId(long userId);
}
