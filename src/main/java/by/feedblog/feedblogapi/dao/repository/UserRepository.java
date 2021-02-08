package by.feedblog.feedblogapi.dao.repository;

import by.feedblog.feedblogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);

//    @Query(value = "select * from users where name = :name", nativeQuery = true)
    void deleteByLogin(String login);
    User findByLogin(String login);
    List<User> findAllByName(String name);
}
