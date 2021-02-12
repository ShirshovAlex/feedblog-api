package by.feedblog.feedblogapi.service;

import by.feedblog.feedblogapi.dao.repository.LikeRepository;
import by.feedblog.feedblogapi.dao.repository.UserRepository;
import by.feedblog.feedblogapi.entity.Like;
import by.feedblog.feedblogapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Like> getAll(){
        return likeRepository.findAll();
    }

    public List<Like> getAllByUser(long id){
        User one = userRepository.getOne(id);
        List<Like> allByUser = likeRepository.getAllByUser(one);
        System.out.println(allByUser);
        return allByUser;
    }

    public Like getById(long id){
        Like one = likeRepository.getOne(id);
        return one;
    }

}
