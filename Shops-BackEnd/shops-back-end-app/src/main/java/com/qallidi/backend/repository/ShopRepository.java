package com.qallidi.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qallidi.backend.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop , Long>{
	Shop findByShop(String shop);
	Shop findByDistance(double distance);
	List<Shop> findAllByOrderByDistanceAsc();
	List<Shop> findAllByOrderByDistanceDesc();
}
