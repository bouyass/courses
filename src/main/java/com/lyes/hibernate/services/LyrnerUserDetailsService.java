package com.lyes.hibernate.services;

import com.lyes.hibernate.entities.User;
import com.lyes.hibernate.repositories.IUserRepository;
import com.lyes.hibernate.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LyrnerUserDetailsService implements UserDetailsService {

    @Qualifier("IUserRepository")
    @Autowired
    IUserRepository userRepository;
    @Autowired
    UserRepositoryImpl userRepositoryBis;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepositoryBis.findByEmail(email);
    }

    public User getUserById(int id){
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public boolean addUser(User user){
      if(userRepository.exists(Example.of(user))){
          return false;
      }else{
          user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
          userRepository.save(user);
          return true;
      }
    }

    public void updateUser(User userArg){
        User user = getUserById(userArg.getId());
        user.setUsername(userArg.getUsername());
        user.setEmail(userArg.getEmail());
        user.setPseudo(userArg.getPseudo());
        userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.delete(getUserById(id));
    }

}
