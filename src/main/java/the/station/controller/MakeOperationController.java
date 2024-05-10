package the.station.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import the.station.model.MakeOperation;
import the.station.model.MakeOperationWithPrice;
import the.station.service.MakeOperationService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping("/make-operations")
public class MakeOperationController {
    MakeOperationService makeOperationService;

    @GetMapping({"", " ", "/"})
    public ResponseEntity<List<MakeOperation>> findAll() {
        return ResponseEntity.of(
            Optional.of(makeOperationService.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<MakeOperation> findById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(makeOperationService.findById(id))
        );
    }
    @PutMapping({"", " ", "/"})
    public ResponseEntity<MakeOperation> saveOrUpdate(@RequestBody MakeOperationWithPrice makeOperationWithPrice) {
        if (makeOperationWithPrice.getIdMakeOperation() == null) {
            return ResponseEntity.of(
                Optional.of(makeOperationService.save(makeOperationWithPrice))
            ); 
        } else {
            return ResponseEntity.of(
                Optional.of(makeOperationService.update(makeOperationWithPrice))
            );
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(makeOperationService.deleteById(id))
        );
    }
}
