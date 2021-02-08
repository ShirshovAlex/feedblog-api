package by.feedblog.feedblogapi.dao.repository;

import by.feedblog.feedblogapi.entity.Post;
import by.feedblog.feedblogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    boolean existsByTitle(String name);
    void deleteByTitle(String name);
    Post findByTitle(String title);
    List<Post> findAllByUser(User user);
}
