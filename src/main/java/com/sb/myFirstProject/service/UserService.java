package com.sb.myFirstProject.service;

import com.sb.myFirstProject.entity.User;
import com.sb.myFirstProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired  // Inject the same bean used in Security config
    private PasswordEncoder passwordEncoder;

    //In place of this use slf4j annotation
//    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        }catch (Exception e){
            log.info("hahaahahahahha");
            log.error("Error occurred for {} : ",user.getUserName(), e);
//            log.debug("hahaahahahahha");
//            log.trace("hahaahahahahha");
//            log.warn("hahaahahahahha");
            return false;
        }
    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
