package by.feedblog.feedblogapi.service;

import by.feedblog.feedblogapi.dao.repository.CommentRepository;
import by.feedblog.feedblogapi.dao.repository.UserRepository;
import by.feedblog.feedblogapi.entity.Comment;
import by.feedblog.feedblogapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(Comment comment, long userId){
        User user = userRepository.getOne(userId);
        comment.setUser(user);
        commentRepository.save(comment);
    }

    public void delete(long id){
        commentRepository.deleteById(id);
    }

    public void updateComment(long id, String newComment){
        Comment one = commentRepository.getOne(id);
        one.setComment(newComment);
        commentRepository.save(one);
    }

    public Comment findComment(long id){
        return commentRepository.getOne(id);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

}
