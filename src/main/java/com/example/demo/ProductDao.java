package com.example.demo;

import java.util.List;

public interface ProductDao {

    void create(Product product);

    List<Product> readAll();

}
