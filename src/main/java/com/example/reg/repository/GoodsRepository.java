package com.example.reg.repository;

import com.example.reg.dto.Goods;
import com.example.reg.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
