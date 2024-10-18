package com.uuu.demo5.repository;


import com.uuu.demo5.entity.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeverageCrudRepository extends CrudRepository<Beverage, Long> {
    List<Beverage> findByTitleContainingIgnoreCase(String title);

    List<Beverage> findByTitleLike(String title);

    List<Beverage> findByPriceBetweenOrderByPriceAsc(Integer lower, Integer upper);

    List<Beverage> findByTitleAndDetailOrderByPriceAsc(String title, String detail);

    List<Beverage> findByTitleIgnoreCaseAndDetailOrderByPriceAsc(String title, String detail);

    List<Beverage> findByTitleAndDetailOrderByPriceAscAllIgnoreCase(String title, String detail);

    List<Beverage> findByTitleOrDetailOrderByPriceAscAllIgnoreCase(String title, String detail);

    Page<Beverage> findAll(Pageable pageable);

    Page<Beverage> findByOrderByPriceAsc(Pageable pageable);

    List<Beverage> findByOrderByPriceAsc();

    List<Beverage> findByOrderByPriceDesc();

    List<Beverage> findMatchByTitle(String t);

    List<Beverage> findMatchByTitleOrderByPriceAsc(String t);

    Integer countByTitle(String t);

    List<Beverage> findMatchByTitleIgnoreCaseOrderByPriceAsc(String title);
}
