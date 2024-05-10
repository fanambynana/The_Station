package the.station.service;

import org.springframework.stereotype.Service;

import the.station.model.Station;
import the.station.repository.AutoCrudOperation;

import java.sql.Connection;
import java.util.List;

@Service
public class StationService {
    AutoCrudOperation<Station> stationAutoCrudOperation;
    
    public StationService(Connection connection) {
        stationAutoCrudOperation = new AutoCrudOperation<>(new Station(), connection);
    }

    public List<Station> findAll() {
        return stationAutoCrudOperation.findAll();
    }
    public Station findById(Integer id) {
        return stationAutoCrudOperation.findById(id);
    }
    public Station save(Station toSave) {
        return stationAutoCrudOperation.save(toSave);
    }
    public Station update(Station toUpdate) {
        return stationAutoCrudOperation.update(toUpdate);
    }
    public Boolean deleteById(Integer id) {
        return stationAutoCrudOperation.deleteById(id);
    }
}
