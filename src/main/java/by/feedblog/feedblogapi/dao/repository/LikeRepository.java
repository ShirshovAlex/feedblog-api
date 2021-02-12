package by.feedblog.feedblogapi.dao.repository;

import by.feedblog.feedblogapi.entity.Like;
import by.feedblog.feedblogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> getAllByUser(User user);

}
