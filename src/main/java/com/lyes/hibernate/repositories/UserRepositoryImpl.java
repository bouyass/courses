package com.lyes.hibernate.repositories;

import com.lyes.hibernate.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByEmail(String email) {
        return entityManager.find(User.class, email);
    }
}