package by.tms.insta.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Post extends AbstractEntity {
    private String description;
    private String url;
    private User creator;
    private List<Comment> comments;
    private List<Like> likes;

    private Post() {

    }

    public static PostBuilder newBuilder() {
        return new Post().new PostBuilder();
    }

    public class PostBuilder {
        public PostBuilder() {
        }

        public PostBuilder setId(long id) {
            Post.this.id = id;
            return this;
        }

        public PostBuilder setDescription(String description) {
            Post.this.description = description;
            return this;
        }

        public PostBuilder setUrl(String url) {
            Post.this.url = url;
            return this;
        }

        public PostBuilder setCreator(User creator) {
            Post.this.creator = creator;
            return this;
        }

        public PostBuilder setComments(List<Comment> comments) {
            Post.this.comments = comments;
            return this;
        }

        public PostBuilder setLikes(List<Like> likes) {
            Post.this.likes = likes;
            return this;
        }

        public PostBuilder setCreateAt(LocalDateTime createAt) {
            Post.this.createAt = createAt;
            return this;
        }

        public Post build() {
            return Post.this;
        }
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public User getCreator() {
        return creator;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", creator=" + creator +
                ", comments=" + comments +
                ", likes=" + likes +
                ", createAt=" + createAt +
                '}';
    }
}
