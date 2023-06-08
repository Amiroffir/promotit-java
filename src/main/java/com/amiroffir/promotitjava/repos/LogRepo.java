package com.amiroffir.promotitjava.repos;

import com.amiroffir.promotitjava.models.LogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends JpaRepository<LogItem, Integer> {
}