package com.hbourgeot.todotech.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hbourgeot.todotech.entities.Customers;

public interface ICustomersRepo extends CrudRepository<Customers, Long>{

  @Override
  long count();

  @Override
  void delete(Customers entity);

  @Override
  void deleteAll();

  @Override
  void deleteAll(Iterable<? extends Customers> entities);

  @Override
  void deleteAllById(Iterable<? extends Long> ids);

  @Override
  void deleteById(Long id);

  @Override
  boolean existsById(Long id);

  @Override
  Iterable<Customers> findAll();

  @Override
  Iterable<Customers> findAllById(Iterable<Long> ids);

  @Override
  Optional<Customers> findById(Long id);

  @Override
  <S extends Customers> S save(S entity);

  @Override
  <S extends Customers> Iterable<S> saveAll(Iterable<S> entities);
  
}
