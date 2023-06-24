package com.hbourgeot.todotech.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{
  private static final long serialVersionUID = -4509451998659894417L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String description;

  @ManyToOne
  public Customers customer;

  @ManyToMany
  public List<Products> products;

  @Column(name = "total_cost")
  public Double totalCost;

  @Transient
  private List<Integer> productQuantity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customers getCustomer() {
    return customer;
  }

  public void setCustomer(Customers customer) {
    this.customer = customer;
  }

  public List<Products> getProducts() {
    return products;
  }

  public void setProducts(List<Products> products) {
    this.products = products;
  }

  public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Integer> getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(List<Integer> productQuantity) {
    this.productQuantity = productQuantity;
  }
}
