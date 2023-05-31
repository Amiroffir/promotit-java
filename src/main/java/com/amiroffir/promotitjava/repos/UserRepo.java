package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.SocialActivist;
import com.amiroffir.promotitjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}