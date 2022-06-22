package com.reactiveexample.reactiveChat.service;

import com.reactiveexample.reactiveChat.domain.User;
import com.reactiveexample.reactiveChat.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsernameWithQuery(username).switchIfEmpty(
                Mono.error(new UsernameNotFoundException(username))
        ).cast(UserDetails.class);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
