package by.tms.insta.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Like extends AbstractEntity {
    private User author;
    private Post post;

    private Like() {
    }
    public static LikeBuilder builder() {
        return new Like().new LikeBuilder();
    }

    public class LikeBuilder {
        public LikeBuilder() {
        }

        public LikeBuilder setId(long id) {
            Like.this.id = id;
            return this;
        }

        public LikeBuilder setAuthor(User author) {
            Like.this.author = author;
            return this;
        }

        public LikeBuilder setPost(Post post) {
            Like.this.post = post;
            return this;
        }

        public LikeBuilder setCreateAt(LocalDateTime createAt) {
            Like.this.createAt = createAt;
            return this;
        }

        public Like build() {
            return Like.this;
        }
    }
public long getId() {
        return id;
}
    public User getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return id == like.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", author=" + author +
                ", post=" + post +
                ", createAt=" + createAt +
                '}';
    }
}
