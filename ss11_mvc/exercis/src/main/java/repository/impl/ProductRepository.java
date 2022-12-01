package repository.impl;

import model.Product;
import repository.IProductRepository;
import service.IProductService;
import service.impl.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(1,new Product(1,"Iphone 14","1.000 USD","đang bán chạy","Apple"));
        productList.put(2,new Product(2,"Laptop Dell 2022","1.100 USD","đang bán chạy","Dell"));
        productList.put(3,new Product(3,"Laptop TUF-Gaming","9000 USD","đang bán chạy","Asus"));
        productList.put(4,new Product(4,"Iphone 13","500 USD","đang bán chạy","Apple"));
        productList.put(5,new Product(5,"Iphone 7","150USD","đang bán giảm giá","Apple"));
    }

    @Override
    public List<Product> selectAll() {
       return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
      productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void remove(int id) {
       productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
       List<Product> searchList = new ArrayList<>();
       for (Product item : selectAll()){
           if (item.getName().contains(name)){
               searchList.add(item);
           }
       }
       return searchList;
    }
}
