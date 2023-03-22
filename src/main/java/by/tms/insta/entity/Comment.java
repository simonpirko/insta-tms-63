package by.tms.insta.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment extends AbstractEntity {
    private String body;
    private User author;
    private Post post;

    public Comment() {
    }

    public static CommentBuilder builder() {
        return new Comment().new CommentBuilder();
    }

    public class CommentBuilder {
        public CommentBuilder() {
        }

        public CommentBuilder setId(long id) {
            Comment.this.id = id;
            return this;
        }

        public CommentBuilder setBody(String body) {
            Comment.this.body = body;
            return this;
        }

        public CommentBuilder setAuthor(User author) {
            Comment.this.author = author;
            return this;
        }

        public CommentBuilder setPost(Post post) {
            Comment.this.post = post;
            return this;
        }

        public CommentBuilder setCreateAt(LocalDateTime createAt) {
            Comment.this.createAt = createAt;
            return this;
        }

        public Comment build() {
            return Comment.this;
        }
    }

    public String getBody() {
        return body;
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
        Comment comment = (Comment) o;
        return id == comment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", post=" + post +
                ", createAt=" + createAt +
                '}';
    }
}
