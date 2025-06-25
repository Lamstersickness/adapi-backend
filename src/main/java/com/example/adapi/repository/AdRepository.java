package com.example.adapi.repository;

import com.example.adapi.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByKeywordsContainingIgnoreCase(String keyword);
}