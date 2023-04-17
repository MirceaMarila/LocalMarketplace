package com.example.LocalMarketplace.controller;

import com.example.LocalMarketplace.dto.Credentials;
import com.example.LocalMarketplace.dto.UserDto;
import com.example.LocalMarketplace.mapper.UserMapper;
import com.example.LocalMarketplace.model.User;
import com.example.LocalMarketplace.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveNewProfile(@RequestBody @Valid UserDto userDto) {
        User user = userMapper.UserDtoToUserMapper(userDto);
        User savedUser = userService.saveNewUser(user);

        return ResponseEntity.created(URI.create("/id/" + savedUser.getId())).body(savedUser);
    }

    @GetMapping("/login")
    public ResponseEntity<User> findProfileById(@RequestBody @Valid Credentials credentials) {
        User user = userService.loginUser(credentials.getEmail(), credentials.getPassword());
        return ResponseEntity.ok().body(user);
    }
}
