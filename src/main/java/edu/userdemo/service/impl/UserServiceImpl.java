package edu.userdemo.service.impl;

import edu.userdemo.dto.UserDTO;
import edu.userdemo.entity.User;
import edu.userdemo.mapping.UserMapper;
import edu.userdemo.repository.UserRepository;
import edu.userdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
   //@Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;

//    @Override
//    public UserDTO createUser(UserDTO userdto) {
//        User original=new User(
//                userdto.getId(),
//                userdto.getName(),
//                userdto.getEmail());
//        User saveduser=userRepository.save(original);
//        UserDTO ud=new UserDTO(
//                saveduser.getId(),
//                saveduser.getName(),
//                saveduser.getEmail()
//        );
//        return ud;
//    }

//    @Override
//    public UserDTO createUser(UserDTO userdto) {
//       User original= UserMapper.userDTOToUser(userdto);
//        User saveduser=userRepository.save(original);
//        UserDTO ud=UserMapper.userToUserDTO(saveduser);
//        return ud;
//    }

//    @Override
//    public UserDTO createUser(UserDTO userdto) {
//        return UserMapper.userToUserDTO(userRepository.save(UserMapper.userDTOToUser(userdto)));
//    }

    @Override
    public UserDTO createUser(UserDTO userdto) {
      User user= modelMapper.map(userdto,User.class);
      User saved=userRepository.save(user);
      return modelMapper.map(saved,UserDTO.class);
    }

//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<User> users=userRepository.findAll();
//        List<UserDTO> udt=users.stream().map((x)->new UserDTO(x.getId(),x.getName(),x.getEmail())).collect(Collectors.toList());
//        return udt;
//    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users=userRepository.findAll();
        List<UserDTO> udt=users.stream().map((x)->modelMapper.map(x,UserDTO.class)).collect(Collectors.toList());
        return udt;
    }

//    @Override
//    public UserDTO getUserById(Integer id) {
//        return UserMapper.userToUserDTO(userRepository.findById(id).get());
//    }
@Override
public UserDTO getUserById(Integer id) {
   return modelMapper.map(userRepository.findById(id).get(),UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userdto, Integer id) {
        User user1=userRepository.findById(id).get();
        user1.setName(userdto.getName());
        user1.setEmail(userdto.getEmail());
        User saved= userRepository.save(user1);
       // return UserMapper.userToUserDTO(saved);
        return modelMapper.map(saved,UserDTO.class);
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "User with id : "+id+" has been deleted";
    }
}
