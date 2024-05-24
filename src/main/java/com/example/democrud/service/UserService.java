package com.example.democrud.service;

import com.example.democrud.dto.request.UserRequest;
import com.example.democrud.dto.request.UserUpdateRequest;
import com.example.democrud.entity.User;

import com.example.democrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
        @Autowired
    private UserRepository userRepository;

        public User createRequest(UserRequest req){
                User user = new User();
                if (userRepository.existsByUsername(req.getUsername()))
                    throw new RuntimeException("User existed");
                //Ko su dung mapstruct de anh xa du lieu tu UserRequest vao User
                user.setUsername(req.getUsername());
               user.setFirstName(req.getFirstName());
               user.setLastName(req.getLastName());
              user.setDob(req.getDob());
               user.setPassword(req.getPassword());
            userRepository.save(user);
                return user;
        }
        public List<User> getUser(){
           return userRepository.findAll();
        }
        public User getU(String id){
//            return userMapper.toUserRespone(userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found")));
            return userRepository.findById(id).
                    orElseThrow(()-> new RuntimeException("User not found"));
        }
//        public UserRespone update(String id, UserUpdateRequest req){
//            User user= userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
//            //su dung mapstruct
//            userMapper.updateUser(user, req);
//
//            // ko su dung mapstruct
////            user.setFirstName(req.getFirstName());
////            user.setLastName(req.getLastName());
////            user.setDob(req.getDob());
////            user.setPassword(req.getPassword());
//            return userMapper.toUserRespone(userRepository.save(user));
//
//
//        }
    public User update(String id, UserUpdateRequest req) {
        User user = getU(id);
        //su dung mapstruct
//       userMapper.updateUser(user, req);

        // ko su dung mapstruct
          user.setFirstName(req.getFirstName());
           user.setLastName(req.getLastName());
          user.setDob(req.getDob());
          user.setPassword(req.getPassword());
        return userRepository.save(user);

    }
        public void delete(String id){
            userRepository.deleteById(id);
        }
}
