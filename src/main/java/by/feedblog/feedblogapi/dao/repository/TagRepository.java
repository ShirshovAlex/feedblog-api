package by.feedblog.feedblogapi.dao.repository;

import by.feedblog.feedblogapi.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
