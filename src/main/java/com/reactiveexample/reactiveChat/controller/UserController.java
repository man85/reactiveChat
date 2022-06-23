package com.reactiveexample.reactiveChat.controller;

import com.reactiveexample.reactiveChat.domain.User;
import com.reactiveexample.reactiveChat.dto.UserDto;
import com.reactiveexample.reactiveChat.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping
    Flux<UserDto> getUser() {
        return userService.findAll().map(usr -> modelMapper.map(usr, UserDto.class));
    }

    @PostMapping
    Mono<ResponseEntity> addUser(@RequestBody User user) {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(user, UserDto.class)));
    }

}
