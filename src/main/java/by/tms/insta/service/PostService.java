package by.tms.insta.service;

import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCPostStorage;
import by.tms.insta.storage.PostStorage;

import java.util.List;
import java.util.Optional;

public class PostService {
    private PostStorage postStorage = JDBCPostStorage.getInstance();
    private PostService INSTANCE;

    private PostService() {

    }

    public PostService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PostService();
        }
        return INSTANCE;
    }

    public Optional<Post> findPost(long id) {
        return postStorage.findById(id);
    }

    public List<Post> findAllPosts() {
        return postStorage.findAll();
    }

    public void removePost(User user) {
        postStorage.remove(user.getId());
    }


}
