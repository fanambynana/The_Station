package the.station.service;

import org.springframework.stereotype.Service;
import the.station.model.Quantity;
import the.station.repository.AutoCrudOperation;
import the.station.repository.KeyAndValue;

import java.sql.Connection;
import java.util.List;

@Service
public class QuantityService {
    AutoCrudOperation<Quantity> quantityAutoCrudOperation;

    public QuantityService(Connection connection) {
        quantityAutoCrudOperation = new AutoCrudOperation<>(new Quantity(), connection);
    }

    public List<Quantity> findAll() {
        return quantityAutoCrudOperation.findAll();
    }
    public Quantity findById(Integer id) {
        return quantityAutoCrudOperation.findById(id);
    }
    public Quantity save(Quantity toSave) {
        return quantityAutoCrudOperation.save(toSave);
    }
    public Quantity update(Quantity toUpdate) {
        return quantityAutoCrudOperation.update(toUpdate);
    }
    public Boolean deleteById(Integer id) {
        return quantityAutoCrudOperation.deleteById(id);
    }
    public List<Quantity> findCustom(List<KeyAndValue> keyAndValueList) {
        return quantityAutoCrudOperation.findCustom(keyAndValueList);
    }
}
