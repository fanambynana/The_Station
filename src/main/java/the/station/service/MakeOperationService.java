package the.station.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import the.station.model.Enum.OperationType;
import the.station.model.MakeOperation;
import the.station.model.MakeOperationWithPrice;
import the.station.model.Price;
import the.station.repository.AutoCrudOperation;
import the.station.repository.KeyAndValue;

import java.sql.Connection;
import java.sql.Types;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Service
public class MakeOperationService {
    AutoCrudOperation<MakeOperation> makeOperationAutoCrudOperation;
    PriceService priceService;
    private final Double MAX_QUANTITY = Double.valueOf(200);

    public MakeOperationService(Connection connection, PriceService priceService) {
        makeOperationAutoCrudOperation = new AutoCrudOperation<>(new MakeOperation(), connection);
        this.priceService = priceService;
    }

    public List<MakeOperation> findAll() {
        return makeOperationAutoCrudOperation.findAll();
    }
    public MakeOperation findById(Integer id) {
        return makeOperationAutoCrudOperation.findById(id);
    }
    public MakeOperation save(MakeOperationWithPrice makeOperationWithPrice) {
        Double price = makeOperationWithPrice.getPrice();
        MakeOperation returned  = null;
        if (price != null) {
            Price productPrice = new LinkedList<>(priceService.findCustom(List.of(
                    new KeyAndValue("idProduct", makeOperationWithPrice.getIdProduct().toString())
            ))).getLast();
            Double unitPrice = productPrice.getUnitPrice();
            Double quantity = Math.round((price / unitPrice) * 100) * 0.01;
            MakeOperation toSave = MakeOperation.builder()
                    .operationType(makeOperationWithPrice.getOperationType())
                    .quantity(quantity)
                    .operationDatetime(Instant.now())
                    .idProduct(makeOperationWithPrice.getIdProduct())
                    .idStation(makeOperationWithPrice.getIdStation())
                    .build();
            returned = makeOperationAutoCrudOperation.save(toSave);
        }
        return returned;
    }
    public MakeOperation save(MakeOperation toSave) {
        MakeOperation returned = null;
        Double quantity = toSave.getQuantity();
        if (quantity <= MAX_QUANTITY) {
            returned = makeOperationAutoCrudOperation.save(toSave);
        }
        return returned;
    }
    public MakeOperation update(MakeOperation toUpdate) {
        return makeOperationAutoCrudOperation.update(toUpdate);
    }
    public Boolean deleteById(Integer id) {
        return makeOperationAutoCrudOperation.deleteById(id);
    }
    public MakeOperation latestInOperation() {
         return new LinkedList<>(makeOperationAutoCrudOperation.findCustom(
                List.of(new KeyAndValue("operationType", OperationType.IN.toString()))
         )).getLast();
    }
    public MakeOperation latestOutOperation() {
        return new LinkedList<>(makeOperationAutoCrudOperation.findCustom(
                List.of(new KeyAndValue("operationType", OperationType.OUT.toString()))
        )).getLast();
    }
}
