package com.example.adapi.service;

import com.example.adapi.model.Ad;
import com.example.adapi.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    @Autowired
    private AdRepository adRepository;

    public Ad saveAd(Ad ad) {
        return adRepository.save(ad);
    }

    public List<Ad> searchByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return adRepository.findAll(); // return all ads if no keyword provided
        }
        return adRepository.findByKeywordsContainingIgnoreCase(keyword);
    }
}
