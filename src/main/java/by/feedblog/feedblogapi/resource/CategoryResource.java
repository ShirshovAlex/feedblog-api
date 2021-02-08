package by.feedblog.feedblogapi.resource;

import by.feedblog.feedblogapi.entity.Category;
import by.feedblog.feedblogapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        if (categoryService.save(category)) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable long id){
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/updateName/{id}")
    public ResponseEntity<Category> updateName(@PathVariable long id, @RequestParam String name){
        categoryService.updateName(id, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> all = categoryService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PostMapping(path = "/get/{id}")
    public ResponseEntity<Category> getById(@PathVariable long id){
        Category byId = categoryService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping(path = "/get/{name}")
    public ResponseEntity<Category> getByName(@PathVariable String name){
        Category byName = categoryService.getByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

}
