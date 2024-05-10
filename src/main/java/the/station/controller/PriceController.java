package the.station.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import the.station.model.Price;
import the.station.service.PriceService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@AllArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceController {
    PriceService priceService;

    @GetMapping({"", " ", "/"})
    public ResponseEntity<List<Price>> findAll() {
        return ResponseEntity.of(
            Optional.of(priceService.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Price> findByIdEntity(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(priceService.findById(id))
        );
    }
    @PutMapping({"", " ", "/"})
    public ResponseEntity<Price> saveOrUpdate(@RequestBody Price price) {
        if (price.getIdPrice() == null) {
            return ResponseEntity.of(
                Optional.of(priceService.save(price))
            );
        } else {
            return ResponseEntity.of(
                Optional.of(priceService.update(price))
            );
        }
    }
    @DeleteMapping("/{id}") 
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(priceService.deleteById(id))
        );
    }
}
