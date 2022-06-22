package com.reactiveexample.reactiveChat.controller;

import com.reactiveexample.reactiveChat.dto.UserDto;
import com.reactiveexample.reactiveChat.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping
    Flux<UserDto> getUser(){
        return userService.findAll().map(usr->modelMapper.map(usr,UserDto.class));
    }
}
