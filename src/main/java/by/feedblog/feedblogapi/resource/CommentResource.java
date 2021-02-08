package by.feedblog.feedblogapi.resource;

import by.feedblog.feedblogapi.entity.Comment;
import by.feedblog.feedblogapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;


    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment, @RequestParam long userId){
        commentService.save(comment, userId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Comment> delete(@RequestParam long id){
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Comment> update(@RequestParam long id, @RequestParam String newComment){
        commentService.updateComment(id,newComment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/findComment/{id}")
    public ResponseEntity<Comment> findComment(@PathVariable long id){
        Comment comment = commentService.findComment(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping(path = "/findAll")
    public ResponseEntity<List<Comment>> findAll(){
        List<Comment> all = commentService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }


}
