package the.station.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import the.station.model.Evaporation;
import the.station.service.EvaporationService;

import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/evaporations")
public class EvaporationController {
    EvaporationService evaporationService;

    @GetMapping("/{id}")
    public ResponseEntity<Evaporation> findById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(evaporationService.findById(id))
        );
    }
    @GetMapping({"", " ", "/"})
    public ResponseEntity<List<Evaporation>> findAll() {
        return ResponseEntity.of(
            Optional.of(evaporationService.findAll())
        );
    }
    @PutMapping({"", " ", "/"})
    public ResponseEntity<Evaporation> saveOrUpdate(@RequestBody Evaporation evaporation) {
        if (evaporation.getIdEvaporation() == null) {
            return ResponseEntity.of(
                Optional.of(evaporationService.save(evaporation))
            );
        } else {
            return ResponseEntity.of(
                Optional.of(evaporationService.update(evaporation))
            );
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(evaporationService.deleteById(id))
        );
    }
}
