/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Youcode.OnlineReservation2.Controller;

import com.Youcode.OnlineReservation2.Dao.UserImp;
import com.Youcode.OnlineReservation2.Exception.ResourceNotFoundException;
import com.Youcode.OnlineReservation2.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserImp userImp;
    
    // creat get all Users api 
    @GetMapping("/users")
    public List<User> getAllUsers() {
		return userImp.findAll();
    }
    
    // creat User 
    @PostMapping("/users")
    public User creatUser(@Valid @RequestBody User user){
        return userImp.save(user);
    }
    
    // get User by id 
    @GetMapping("/Users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
        	throws ResourceNotFoundException {
    	User user = userImp.findById(userId)
    		.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
    	return ResponseEntity.ok().body(user);
    }
    // update User by id
    @PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userImp.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setFullName(userDetails.getFullName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setVerification(userDetails.getVerification());
                
		final User updatedUser = userImp.save(user);
		return ResponseEntity.ok(updatedUser);
	}
    // delete User by id
       	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userImp.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
		userImp.delete(user);
		return ResponseEntity.ok().build();
	}
}
