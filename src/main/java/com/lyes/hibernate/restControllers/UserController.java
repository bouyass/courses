package com.lyes.hibernate.restControllers;

import com.lyes.hibernate.entities.User;
import com.lyes.hibernate.services.LyrnerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    LyrnerUserDetailsService userDetailsService;

    @GetMapping("user/{id}")
    public ResponseEntity<User> getArticleById(@PathVariable("id") Integer id) {
        User user = userDetailsService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @GetMapping("users")
    public ResponseEntity<List<User>> getAllArticles() {
        List<User> list = userDetailsService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    @PostMapping("user")
    public ResponseEntity<Void> addArticle(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userDetailsService.addUser(user);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("user")
    public ResponseEntity<User> updateArticle(@RequestBody User user) {
        userDetailsService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        userDetailsService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
