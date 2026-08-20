package com.bm.rest_web_services.Controller;

import com.bm.rest_web_services.DTO.UserResponse;
import com.bm.rest_web_services.Entity.User;
import com.bm.rest_web_services.Exception.UserNotFoundException;
import com.bm.rest_web_services.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Create User
    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody User users) {
        User savedUser = userRepository.save(users);

//        URI location = URI.create("/users/" + savedUser.id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.id).toUri();
        UserResponse createUserResponse = new UserResponse(
                "User Saved Successfully",
                savedUser
        );

        return ResponseEntity.created(location).body(createUserResponse);
    }

    //Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get User By Id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        if (!userRepository.existsById(id))
            throw new UserNotFoundException("ID: " + id + " Not Found");
        return userRepository.findById(id).get();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Integer id){
        if (!userRepository.existsById(id))
            throw new UserNotFoundException("ID: " + id + " Not Found");
        userRepository.deleteById(id);
    }
}
