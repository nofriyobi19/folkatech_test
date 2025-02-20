package com.folkatechtest.folkatechtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.folkatechtest.folkatechtest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("""
            SELECT u
            FROM User u
            WHERE u.email = :email
            """)
    public User getUserByEmail(String email);
}
