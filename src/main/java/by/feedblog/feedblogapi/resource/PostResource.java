package by.feedblog.feedblogapi.resource;

import by.feedblog.feedblogapi.entity.Category;
import by.feedblog.feedblogapi.entity.Like;
import by.feedblog.feedblogapi.entity.Post;
import by.feedblog.feedblogapi.entity.User;
import by.feedblog.feedblogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostResource {

    @Autowired
    private PostService postService;

    @PostMapping(path = "/save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        if (postService.save(post)) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/updateDescription/{id}")
    public ResponseEntity<Post> updateDescription(@PathVariable long id, @RequestParam String description) {
        postService.updateDescription(id, description);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Post> deletePostById(@PathVariable long id) {
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{title}")
    public ResponseEntity<Post> deletePostById(@PathVariable String title) {
        postService.deleteByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> all = postService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "/getPost/{id}")
    public ResponseEntity<Post> getById(@PathVariable long id) {
        Post byId = postService.getById(id);
        if (byId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/getPostByTitle/{title}")
    public ResponseEntity<Post> getById(@PathVariable String title) {
        Post byTitle = postService.getByTitle(title);
        if (byTitle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(byTitle, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/isUnChecked")
    public ResponseEntity<List<Post>> isUnChecked() {
        List<Post> unChecked = postService.isUnChecked();
        return new ResponseEntity<>(unChecked, HttpStatus.OK);
    }

    @PostMapping(path = "/isChecked")
    public ResponseEntity<List<Post>> isChecked() {
        List<Post> checked = postService.isChecked();
        return new ResponseEntity<>(checked, HttpStatus.OK);
    }

    @PostMapping(path = "/getPostByUser")
    public ResponseEntity<List<Post>> getAllByUser(@RequestBody User user) {
        List<Post> allByUser = postService.getAllByUser(user);
        return new ResponseEntity<>(allByUser, HttpStatus.OK);
    }

    @PostMapping(path = "/updateCategory/{id}")
    public ResponseEntity<Post> updateCategoryById(@PathVariable long id, @RequestBody Category category) {
        postService.updateCategory(id, category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/getLike/{id}")
    public ResponseEntity<Long> getLikes(@PathVariable long id) {
        long likes = postService.getLikes(id);
        return new ResponseEntity<>(likes ,HttpStatus.OK);
    }

    @PostMapping(path = "/saveComment")
    public ResponseEntity<Post> saveComment(long id, long userId, String comment) {
        postService.setComment(id, comment, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/saveTag")
    public ResponseEntity<Post> saveTag(long id, String tag){
        postService.saveTag(id,tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/doLike")
    public ResponseEntity<Post> doLike(long idPost, long idUser){
        postService.doLike(idPost, idUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/getCountViews/{id}")
    public ResponseEntity<Long> getCountViews(@PathVariable long id){
        long countViews = postService.getCountViews(id);
        return new ResponseEntity<>(countViews, HttpStatus.OK);
    }

    @PostMapping(path = "/check/{id}")
    public ResponseEntity<Post> check(@PathVariable long id){
        postService.check(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/getAllLikes/{id}")
    public ResponseEntity<List<Like>> getAllLikes(@PathVariable long id){
        List<Like> allLikes = postService.getAllLikes(id);
        return new ResponseEntity<>(allLikes, HttpStatus.OK);
    }

    @PostMapping(path = "/getAllByCategory/{id}")
    public ResponseEntity<List<Post>> getAllByCategory(@PathVariable long id){
        List<Post> allByCategory = postService.getAllByCategory(id);
        System.out.println(allByCategory);
        return new ResponseEntity<>(allByCategory, HttpStatus.OK);
    }

    @PostMapping(path = "/findAllByTag/{id}")
    public ResponseEntity<List<Post>> findAllByTag(@PathVariable long id){
        List<Post> allByTag = postService.getAllByTag(id);
        System.out.println(allByTag);
        return new ResponseEntity<>(allByTag, HttpStatus.OK);
    }

    @PostMapping(path = "/sortByLikeAsc")
    public ResponseEntity<List<Post>> sortByLikeAsc(){
        List<Post> allByOrderAsc = postService.getAllByOrderAsc();
        return new ResponseEntity<>(allByOrderAsc, HttpStatus.OK);
    }

    @PostMapping(path = "/sortByLikeDesc")
    public ResponseEntity<List<Post>> sortByLikeDesc(){
        List<Post> allByOrderDesc = postService.getAllByOrderDesc();
        return new ResponseEntity<>(allByOrderDesc, HttpStatus.OK);
    }

}
