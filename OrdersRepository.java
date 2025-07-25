package com.football.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.store.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
