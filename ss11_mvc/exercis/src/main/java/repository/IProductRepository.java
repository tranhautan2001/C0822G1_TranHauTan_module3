package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();

    void save(Product customer);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);

    List<Product> findByName(String name);
}
