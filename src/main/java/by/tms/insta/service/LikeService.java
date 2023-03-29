package by.tms.insta.service;

import by.tms.insta.entity.Like;
import by.tms.insta.storage.JDBCLikesStorage;
import by.tms.insta.storage.LikesStorage;

import java.util.List;
import java.util.Optional;

public class LikeService {
    private LikesStorage likesStorage = JDBCLikesStorage.getInstance();
    private static LikeService instance;
    private LikeService() {

    }
    public static LikeService getInstance() {
        if (instance == null) {
            instance = new LikeService();
        }
        return instance;
    }

    public Optional<Like> findById(long id) {
        return likesStorage.findById(id);
    }

    public void saveLike(Like like) {
        likesStorage.save(like);
    }

    public void deleteLike(long userId) {
        likesStorage.remove(userId);
    }

    public List<Like> findAll(long id) {
        return likesStorage.findAll();
    }

    public Optional<Like> findLikeByUserId(long userId) {
        return likesStorage.findLikeByUserId(userId);
    }
    public List<Like> findLikeByPost(long post) {
        return likesStorage.findLikeByPost(post);
    }

}
