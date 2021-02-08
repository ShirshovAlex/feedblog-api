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
            Post one = postRepository.getOne(id);
            long countViews = one.getCountViews();
            one.setCountViews(++countViews);
            postRepository.save(one);
            return one;
        }
        return null;
    }

    public Post getByTitle(String title) {
        if (postRepository.existsByTitle(title)) {
            Post byTitle = postRepository.findByTitle(title);
            long countViews = byTitle.getCountViews();
            byTitle.setCountViews(++countViews);
            postRepository.save(byTitle);
            return byTitle;
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

    public void doLike(long idPost){
        Post one = postRepository.getOne(idPost);
        List<Like> likes = one.getLikes();
        likes.add(new Like());
        postRepository.save(one);
    }

    public long getLikes(long id){
        Post one = postRepository.getOne(id);
        List<Like> likes = one.getLikes();
        return likes.size();
    }

    public long getCountViews(long id){
        Post one = postRepository.getOne(id);
        long countViews = one.getCountViews();
        return countViews;
    }

    public void check(long id){
        Post one = postRepository.getOne(id);
        one.setChecked(true);
        postRepository.save(one);
    }
}
