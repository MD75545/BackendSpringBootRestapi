package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByuName(String uName);

}
