package com.example.sushiorder.repository;

import com.example.sushiorder.entity.Sushi_order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SushiOrderRepository extends JpaRepository<Sushi_order,Long> {
    @Query(value="select * from sushi_order s where s.id=:id", nativeQuery = true)
    public Sushi_order findById(long id);
}