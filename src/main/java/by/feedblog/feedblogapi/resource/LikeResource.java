package by.feedblog.feedblogapi.resource;

import by.feedblog.feedblogapi.entity.Like;
import by.feedblog.feedblogapi.entity.User;
import by.feedblog.feedblogapi.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "like")
public class LikeResource {

    @Autowired
    LikeService likeService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Like>> getAll(){
        List<Like> all = likeService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "/getAllByUser")
    public ResponseEntity<List<Like>> getAllByUser(@RequestBody User user){
        List<Like> allByUser = likeService.getAllByUser(user);
        return new ResponseEntity<>(allByUser, HttpStatus.OK);
    }

    @PostMapping(path = "/getById/{id}")
    public ResponseEntity<Like> getById(@PathVariable long id){
        Like byId = likeService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }
}
