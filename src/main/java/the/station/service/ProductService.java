package the.station.service;

import org.springframework.stereotype.Service;

import the.station.model.Product;
import the.station.repository.AutoCrudOperation;
import the.station.repository.KeyAndValue;

import java.sql.Connection;
import java.util.List;

@Service
public class ProductService {
    AutoCrudOperation<Product> productAutoCrudOperation;
    
    public ProductService(Connection connection){
        productAutoCrudOperation = new AutoCrudOperation<>(new Product(), connection);
    }

   public List<Product> findAll() {
       return productAutoCrudOperation.findAll();
   }
   public Product findById(Integer id) {
       return productAutoCrudOperation.findById(id);
   }
   public List<Product> findCustom(List<KeyAndValue> keyAndValueList) {
        return productAutoCrudOperation.findCustom(keyAndValueList);
   }
   public Product save(Product toSave) {
       return productAutoCrudOperation.save(toSave);
   }
   public Product update(Product toUpdate) {
       return productAutoCrudOperation.update(toUpdate);
   }
   public Boolean deleteById(Integer id) {
       return productAutoCrudOperation.deleteById(id);
   }
}
