package the.station.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import the.station.model.Evaporation;
import the.station.repository.AutoCrudOperation;

@Service
public class EvaporationService {
    AutoCrudOperation<Evaporation> evaporationAutoCrudOperation;

    public EvaporationService(Connection connection) {
        evaporationAutoCrudOperation = new AutoCrudOperation<>(new Evaporation(), connection);
    }

    public List<Evaporation> findAll() {
        return evaporationAutoCrudOperation.findAll();
    }
    public Evaporation findById(Integer id) {
        return evaporationAutoCrudOperation.findById(id);
    }
    public Evaporation save(Evaporation toSave) {
        return evaporationAutoCrudOperation.save(toSave);
    }
    public Evaporation update(Evaporation toUpdate) {
        return evaporationAutoCrudOperation.update(toUpdate);
    }
    public Boolean deleteById(Integer id) {
        return evaporationAutoCrudOperation.deleteById(id);
    }
}
