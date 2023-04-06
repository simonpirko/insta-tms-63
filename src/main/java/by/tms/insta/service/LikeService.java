package by.tms.insta.service;


import by.tms.insta.entity.Like;
import by.tms.insta.dao.JDBCLikesDAO;
import by.tms.insta.dao.LikesDAO;

import java.util.List;
import java.util.Optional;

    public class LikeService {
        private LikesDAO likesDao = JDBCLikesDAO.getInstance();
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
            return likesDao.findById(id);
        }

        public void saveLike(Like like) {
            likesDao.save(like);
        }

        public void deleteLike(long userId) {
            likesDao.remove(userId);
        }

        public List<Like> findAll(long id) {
            return likesDao.findAll();
        }

        public Optional<Like> findLikeByUserId(long userId) {
            return likesDao.findLikeByUserId(userId);
        }
        public List<Like> findLikeByPost(long post) {
            return likesDao.findLikeByPost(post);
        }

    }
