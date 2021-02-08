package by.feedblog.feedblogapi.service;

import by.feedblog.feedblogapi.dao.repository.CategoryRepository;
import by.feedblog.feedblogapi.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean save(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    public void deleteById(long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
    }

    public void updateName(long id, String name) {
        if (categoryRepository.existsById(id)) {
            Category one = categoryRepository.getOne(id);
            one.setName(name);
            categoryRepository.save(one);
        }
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getByName(String name) {
        if (categoryRepository.existsByName(name)) {
            return categoryRepository.findByName(name);
        }
        return null;
    }

    public Category getById(long id) {
        if (categoryRepository.existsById(id)) {
            return categoryRepository.getOne(id);
        }
        return null;
    }


}
