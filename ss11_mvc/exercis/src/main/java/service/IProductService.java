package service;

import model.Product;

import java.util.List;

public interface IProductService  {
    List<Product> selectAll();

    void save(Product customer);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);

    List<Product> findByName(String name);

}
