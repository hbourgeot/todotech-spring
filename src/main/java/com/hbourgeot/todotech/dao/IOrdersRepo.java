package com.hbourgeot.todotech.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hbourgeot.todotech.entities.Orders;

public interface IOrdersRepo extends CrudRepository<Orders, Long>{

  @Override
  long count();

  @Override
  void delete(Orders entity);

  @Override
  void deleteAll();

  @Override
  void deleteAll(Iterable<? extends Orders> entities);

  @Override
  void deleteAllById(Iterable<? extends Long> ids);

  @Override
  void deleteById(Long id);

  @Override
  boolean existsById(Long id);

  @Override
  Iterable<Orders> findAll();

  @Override
  Iterable<Orders> findAllById(Iterable<Long> ids);

  @Override
  Optional<Orders> findById(Long id);

  @Override
  <S extends Orders> S save(S entity);

  @Override
  <S extends Orders> Iterable<S> saveAll(Iterable<S> entities);
  
}
