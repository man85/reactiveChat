package com.reactiveexample.reactiveChat.repository;

import com.reactiveexample.reactiveChat.domain.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RoleRepository extends ReactiveCrudRepository<Role, Integer> {
}
