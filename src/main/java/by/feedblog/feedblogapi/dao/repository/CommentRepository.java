package by.feedblog.feedblogapi.dao.repository;

import by.feedblog.feedblogapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
