package com.tourism.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.tourism.demo.entity.User;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path="user")
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByname(String name);
}
