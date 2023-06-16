package com.hbourgeot.todotech.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hbourgeot.todotech.entities.User;

public interface IUserRepo extends CrudRepository<User, java.lang.String> {

  @Override
  long count();

  @Override
  void delete(User entity);

  @Override
  void deleteAll();

  @Override
  void deleteAll(Iterable<? extends User> entities);

  @Override
  void deleteAllById(Iterable<? extends String> ids);

  @Override
  void deleteById(String id);

  @Override
  boolean existsById(String id);

  @Override
  Iterable<User> findAll();

  @Override
  Iterable<User> findAllById(Iterable<String> ids);

  @Override
  Optional<User> findById(String id);

  @Override
  <S extends User> S save(S entity);

  @Override
  <S extends User> Iterable<S> saveAll(Iterable<S> entities);
  
}
