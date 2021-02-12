package by.feedblog.feedblogapi.resource;

import by.feedblog.feedblogapi.entity.User;
import by.feedblog.feedblogapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        if (userService.save(user)) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/updatePassword/{id}")//localhost:8080/updatePassword/1?password=newPassword
    public ResponseEntity<User> updatePassword(@PathVariable long id, @RequestParam String password) {
        if (userService.updatePassword(id, password)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/updateName/{id}")
    public ResponseEntity<User> updateName(@PathVariable long id, @RequestParam String name) {
        if (userService.updateName(name, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<User> deleteById(@PathVariable long id) {
        if (userService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/deleteByLogin/{login}")
    public ResponseEntity<User> deleteByLogin(@PathVariable String login) {
        if (userService.deleteByLogin(login)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> all = userService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "/getByLogin")
    public ResponseEntity<User> getByLogin(@RequestParam String login) {
        User byLogin = userService.getByLogin(login);
        if (byLogin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(byLogin, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/getAll/{name}")
    public ResponseEntity<List<User>> getAllByName(@PathVariable String name) {
        List<User> allByName = userService.getAllByName(name);
        return new ResponseEntity<>(allByName, HttpStatus.OK);
    }
}
