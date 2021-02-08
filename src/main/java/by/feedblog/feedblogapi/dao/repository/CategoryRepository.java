package by.feedblog.feedblogapi.dao.repository;

import by.feedblog.feedblogapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
    Category findByName(String name);
}
