package com.example.demo.repository;

import com.example.demo.entity.PeakEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeakRepository extends JpaRepository<PeakEntity, Integer> {

    boolean existsByName(String name);


}
