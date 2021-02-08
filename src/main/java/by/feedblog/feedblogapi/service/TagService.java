package by.feedblog.feedblogapi.service;

import by.feedblog.feedblogapi.dao.repository.TagRepository;
import by.feedblog.feedblogapi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    public Tag findTag(long id) {
        return tagRepository.getOne(id);
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public void update(long id, String tag) {
        Tag one = tagRepository.getOne(id);
        one.setTag(tag);
        tagRepository.save(one);
    }

    public void delete(long id) {
        tagRepository.deleteById(id);
    }
}
