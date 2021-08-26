package com.example.reg.repository;

import com.example.reg.dto.GoodsImage;
import com.example.reg.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GoodsImageRepository extends JpaRepository<GoodsImage, Long> {
}
