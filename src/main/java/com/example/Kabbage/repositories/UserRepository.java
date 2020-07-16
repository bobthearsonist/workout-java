package com.example.Kabbage.repositories;

import java.util.List;

import com.example.Kabbage.models.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByUserName(@Param("userName") String userName);
}