package com.aiyolo.repository;

import com.aiyolo.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description ShopRepository
 * @date 2018年1月23日 下午14:23
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
}
