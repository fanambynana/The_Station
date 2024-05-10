package the.station.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import the.station.model.Price;
import the.station.repository.AutoCrudOperation;
import the.station.repository.KeyAndValue;

@Service
public class PriceService {
    AutoCrudOperation<Price> priceAutoCrudOperation;

    public PriceService(Connection connection) {
        priceAutoCrudOperation = new AutoCrudOperation<>(new Price(), connection);
    }

    public List<Price> findAll() {
        return priceAutoCrudOperation.findAll();
    }
    public Price findById(Integer id) {
        return priceAutoCrudOperation.findById(id);
    }
    public List<Price> findCustom(List<KeyAndValue> keyAndValueList) {
        return priceAutoCrudOperation.findCustom(keyAndValueList);
    }
    public Price save(Price toSave) {
        return priceAutoCrudOperation.save(toSave);
    }
    public Price update(Price toUpdate) {
        return priceAutoCrudOperation.update(toUpdate);
    }
    public Boolean deleteById(Integer id) {
        return priceAutoCrudOperation.deleteById(id);
    }
}