package com.aerosign.repository;

import com.aerosign.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<User, Long> {
}
