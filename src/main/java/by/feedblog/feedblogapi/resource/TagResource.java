package by.feedblog.feedblogapi.resource;


import by.feedblog.feedblogapi.entity.Tag;
import by.feedblog.feedblogapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tag")
public class TagResource {

    @Autowired
    private TagService tagService;

    @PostMapping(path = "/save")
    public ResponseEntity<Tag> save(Tag tag) {
        tagService.save(tag);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PostMapping(path = "findTag/{id}")
    public ResponseEntity<Tag> findTag(@PathVariable long id) {
        Tag tag = tagService.findTag(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<List<Tag>> findAll() {
        List<Tag> all = tagService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Tag> update(long id, String newTag) {
        tagService.update(id, newTag);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Tag> delete(@PathVariable long id){
        tagService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
