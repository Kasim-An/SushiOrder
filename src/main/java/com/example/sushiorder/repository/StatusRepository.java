package com.example.sushiorder.repository;

import com.example.sushiorder.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    @Query(value="select * from status s where s.name=:name", nativeQuery = true)
    public Status findByName(String name);
}