package com.example.demo.dao;

import com.example.demo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface NumberDao extends JpaRepository<Test, Long> {

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    String getId();

    @Query(value = "REPLACE INTO test (ip) VALUES (:ip)", nativeQuery = true)
    void addId(String ip) throws Exception;


}
