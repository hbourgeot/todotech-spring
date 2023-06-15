package com.hbourgeot.todotech.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hbourgeot.todotech.entities.Products;

public interface IProductsRepo extends CrudRepository<Products, Long> {

  @Override
  long count();

  @Override
  void delete(Products entity);

  @Override
  void deleteAll();

  @Override
  void deleteAll(Iterable<? extends Products> entities);

  @Override
  void deleteAllById(Iterable<? extends Long> ids);

  @Override
  void deleteById(Long id);

  @Override
  boolean existsById(Long id);

  @Override
  Iterable<Products> findAll();

  @Override
  Iterable<Products> findAllById(Iterable<Long> ids);

  @Override
  Optional<Products> findById(Long id);

  @Override
  <S extends Products> S save(S entity);

  @Override
  <S extends Products> Iterable<S> saveAll(Iterable<S> entities);
  
}
