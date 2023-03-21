package by.tms.insta.service;

import by.tms.insta.entity.Post;
import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCPostStorage;
import by.tms.insta.storage.PostStorage;

import java.util.List;
import java.util.Optional;

public class PostService {
    private PostStorage postStorage = JDBCPostStorage.getInstance();
    private static PostService instance;

    private PostService() {

    }

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }

    public Optional<Post> findPost(Post post) {
        return postStorage.findById(post.getId());
    }

    public List<Post> findAllPosts() {
        return postStorage.findAll();
    }

    public void removePost(long id) {
        postStorage.remove(id);
    }

    public void createPost(Post post) {
        postStorage.save(post);
    }

    public List<Post> findPosts(long id) {
        return postStorage.remove(id);
    }

    public void createPost(Post post) {
        postStorage.save(post);
    }


}
