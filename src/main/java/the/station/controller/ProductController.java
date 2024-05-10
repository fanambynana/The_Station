package the.station.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import the.station.model.Product;
import the.station.service.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @GetMapping({"", " ", "/"})
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.of(
            Optional.of(productService.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findByIdEntity(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(productService.findById(id))
        );
    }
    @PutMapping({"", " ", "/"})
    public ResponseEntity<Product> saveOrUpdate(@RequestBody Product product) {
        if (product.getIdProduct() == null) {
            return ResponseEntity.of(
                Optional.of(productService.save(product))
            );
        } else {
            return ResponseEntity.of(
                Optional.of(productService.update(product))
            );
        }
    }
    @DeleteMapping("/{id}") 
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(productService.deleteById(id))
        );
    }
}
