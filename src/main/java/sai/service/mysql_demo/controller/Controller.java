package sai.service.mysql_demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sai.service.mysql_demo.User.UserDTO;
import sai.service.mysql_demo.service.Service;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping("/test")
    public String testMethod() {
        return service.testMethodService();
    }

    @GetMapping("/test/connection")
    public String testConnectionMethod() {
        return service.testConnectionMethodService();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getuserbyid(@PathVariable Integer id) {
        Optional<UserDTO> userDTo = service.getuserbyId(id);
        return (userDTo.isPresent()) ? new ResponseEntity<>(userDTo.get(), HttpStatus.FOUND) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/user/all")
    public List<UserDTO> getAllUser() {
        return service.getalluser();

    }

    @PostMapping("/user/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO newuser = service.addUsers(userDTO);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }
}