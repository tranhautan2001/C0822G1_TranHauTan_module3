package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> selectAll() {
        return iProductRepository.selectAll() ;
    }

    @Override
    public void save(Product customer) {
        iProductRepository.save(customer);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product customer) {
     iProductRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
       iProductRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }
}
