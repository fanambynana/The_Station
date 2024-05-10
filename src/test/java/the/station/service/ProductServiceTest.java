package the.station.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import the.station.dbConnection.DbConnect;
import the.station.model.Product;

import java.util.List;

@SpringBootTest
class ProductServiceTest {
    ProductService productService = new ProductService(new DbConnect().createTestConnection());
    
    private static Product productToSave = new Product(
        null,
        "petrole test"
    );

    @Test
    void findAllOk() {
        List<Product> products = productService.findAll();
        Assertions.assertTrue(products != null && products.size() > 0);
        System.err.println("Find all products :");
        System.err.println(products);
    }
    @Test
    void findByIdOk() {
        int id = 2;
        Product product = productService.findById(id);
        Assertions.assertEquals(product.getIdProduct(), id);
        System.err.println(String.format(
                "Find product by id %s :",
                id
        ));
        System.err.println(product);
    }
    @Test
    void saveOk() {
        productService.save(productToSave);
        List<Product> products = productService.findAll();
        Product saved = products.get(products.size() - 1);
        productToSave.setIdProduct(saved.getIdProduct());
        Assertions.assertEquals(productToSave, saved);
        System.err.println("Save product :");
        System.err.println(saved);
    }
    @Test
    void deleteByIdOk() {
        List<Product> products = productService.findAll();
        int id = products.get(products.size() - 1).getIdProduct();
        productService.deleteById(id);
        System.err.println(String.format(
                "Delete product by id %s :",
                id
        ));
        System.err.println(productService.findAll());
    }
    @Test
    void updateOk() {
        List<Product> products = productService.findAll();
        productToSave.setIdProduct(products.get(products.size() - 1).getIdProduct());
        productToSave.setProductName("essence test");
        System.err.println("Update product :");
        System.err.println(productService.findAll());
    }
}
