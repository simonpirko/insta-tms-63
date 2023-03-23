package by.tms.insta.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class User extends AbstractEntity {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private List<Post> posts;
    private LocalDateTime updateAt;
    private String avatar;

    public User() {
    }

    public static UserBuilder builder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {
        public UserBuilder() {
        }

        public UserBuilder setId(long id) {
            User.this.id = id;
            return this;
        }

        public UserBuilder setAvatar(String avatar) {

            User.this.avatar = avatar;
            return this;
        }

        public UserBuilder setUsername(String username) {
            User.this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public UserBuilder setFullName(String fullName) {
            User.this.fullName = fullName;
            return this;
        }

        public UserBuilder setPosts(List<Post> posts) {
            User.this.posts = posts;
            return this;
        }

        public UserBuilder setUpdateAt(LocalDateTime updateAt) {
            User.this.updateAt = updateAt;
            return this;
        }

        public UserBuilder setCreateAt(LocalDateTime createAt) {
            User.this.createAt = createAt;
            return this;
        }

        public User build() {
            return User.this;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", posts=" + posts +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
