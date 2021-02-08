package by.feedblog.feedblogapi.service;

import by.feedblog.feedblogapi.dao.repository.PostRepository;
import by.feedblog.feedblogapi.dao.repository.UserRepository;
import by.feedblog.feedblogapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    public boolean save(Post post) {
        if (postRepository.existsByTitle(post.getTitle())) {
            return false;
        }
        long id = post.getUser().getId();
        long id1 = post.getCategory().getId();

        postRepository.save(post);
        return true;
    }

    public void updateDescription(long id, String string) {
        if (postRepository.existsById(id)) {
            Post one = postRepository.getOne(id);
            one.setDescription(string);
            postRepository.save(one);
        }
    }

    public void deleteById(long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        }
    }

    public void deleteByTitle(String title) {
        if (postRepository.existsByTitle(title)) {
            postRepository.deleteByTitle(title);
        }
    }

    public void count(Post post) {
//        jdbcPostDao.view(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getById(long id) {
        if (postRepository.existsById(id)) {
            return postRepository.getOne(id);
        }
        return null;
    }

    public Post getByTitle(String title) {
        if (postRepository.existsByTitle(title)) {
            return postRepository.findByTitle(title);
        }
        return null;
    }

    public List<Post> isUnChecked() {
        List<Post> all = postRepository.findAll();
        List<Post> allUnChecked = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (!all.get(i).isChecked()) {
                allUnChecked.add(all.get(i));
            }
        }
        return allUnChecked;
    }

    public List<Post> isChecked() {
        List<Post> all = postRepository.findAll();
        List<Post> allChecked = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).isChecked()) {
                allChecked.add(all.get(i));
            }
        }
        return allChecked;
    }

    public void check(long id, boolean b) {
//        jdbcPostDao.check(id, b);
    }


    public List<Post> getAllByUser(User user) {
        return postRepository.findAllByUser(user);
    }

    public void updateCategory(long postId, Category byId) {
        Post one = postRepository.getOne(postId);
        one.setCategory(byId);
        postRepository.save(one);
    }

    public void like(Post post) {
//        jdbcPostDao.getLikes(post);
    }

    public void updateLikes(long id){
        Post one = postRepository.getOne(id);
        long likes = one.getLikes();
        one.setLikes(++likes);
        postRepository.save(one);
    }

    public void setComment(long id, String comment, long userId){
        Post one = postRepository.getOne(id);
        User one1 = userRepository.getOne(userId);

        List<Comment> comment1 = one.getComment();

        comment1.add(new Comment(comment, one1));
        postRepository.save(one);
    }

    public void saveTag(long id, String tag){
        Post one = postRepository.getOne(id);
        List<Tag> tags = one.getTags();
        tags.add(new Tag(tag));
        postRepository.save(one);
    }
}
