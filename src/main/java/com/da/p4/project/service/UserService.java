package com.da.p4.project.service;

import com.da.p4.project.dto.UserDto;
import com.da.p4.project.mapper.UserMapper;
import com.da.p4.project.model.User;
import com.da.p4.project.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private static final String SUCCESS = "success";

    private static final String FAILED = "fail";

    private final UserRepo userRepo;

   // private final UserMapper userMapper;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }
    public void updateUser(UserDto userDto, Long userId) {
         userRepo.findById(userId).ifPresentOrElse(u->{
          //   User user = userMapper.toUserModel(userDto);

             User user = new User();
             user.setId(userDto.getId());
             user.setUsername(userDto.getUsername());
             user.setPassword(userDto.getPassword());
             user.setRole(userDto.getRole());
             userRepo.save(user);
         }, ()-> {throw new RuntimeException("User cannot be found");});
    }
    public String deleteUser(Long id){
        try {
            userRepo.deleteById(id);
            return SUCCESS;
        }catch (Exception e){
            log.error("Following error occurred " + e.getMessage());
            return FAILED;
        }

    }

    public String deleteAll(){
        try {
            userRepo.deleteAll();
            return SUCCESS;
        }catch (Exception exception){
            log.error("Following error occurred " + exception.getMessage());
            return FAILED;
        }
    }

    public String addUser(UserDto userDto) {
        try {
       //     User user = userMapper.toUserModel(userDto);

            User user = new User();
            user.setId(userDto.getId());
            user.setUsername(userDto.getUsername());
            user.setFullName(userDto.getFullName());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());
            userRepo.save(user);
            return SUCCESS;
        } catch (Exception exception){
            log.error("Following error occurred " + exception.getMessage());
            return FAILED;
        }

    }
}
