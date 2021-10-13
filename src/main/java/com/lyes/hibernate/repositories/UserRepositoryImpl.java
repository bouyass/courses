package com.lyes.hibernate.repositories;

import com.lyes.hibernate.entities.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserRepositoryImpl{

    @PersistenceContext
    private EntityManager entityManager;

    public User findByEmail(String email) {
        String hql = "FROM User as user WHERE user.email = ?1";
        System.out.println("Email "+email);
        return (User) entityManager.createQuery(hql).setParameter(1,email).getSingleResult();
    }
}