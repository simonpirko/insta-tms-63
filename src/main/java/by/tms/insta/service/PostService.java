package by.tms.insta.service;

import by.tms.insta.storage.JDBCPostStorage;
import by.tms.insta.storage.PostStorage;

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


}
