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
import the.station.model.Station;
import the.station.service.StationService;

@RestController
@AllArgsConstructor
@RequestMapping("/stations")
public class StationController {
    StationService stationService;

    @GetMapping({"", " ", "/"})
    public ResponseEntity<List<Station>> findAll() {
        return ResponseEntity.of(
            Optional.of(stationService.findAll())
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Station> findByIdEntity(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(stationService.findById(id))
        );
    }
    @PutMapping({"", " ", "/"})
    public ResponseEntity<Station> saveOrUpdate(@RequestBody Station station) {
        if (station.getIdStation() == null) {
            return ResponseEntity.of(
                Optional.of(stationService.save(station))
            );
        } else {
            return ResponseEntity.of(
                Optional.of(stationService.update(station))
            );
        }
    }
    @DeleteMapping("/{id}") 
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        return ResponseEntity.of(
            Optional.of(stationService.deleteById(id))
        );
    }
}
