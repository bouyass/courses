package com.lyes.hibernate.repositories;

import com.lyes.hibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {
    public User findByEmail(String email);
}
