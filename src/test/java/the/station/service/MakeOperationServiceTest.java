package the.station.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import the.station.dbConnection.DbConnect;
import the.station.model.Enum.OperationType;
import the.station.model.MakeOperation;
import the.station.model.MakeOperationWithPrice;

import java.sql.Connection;
import java.time.Instant;

@SpringBootTest
public class MakeOperationServiceTest {
    Connection testConnection = new DbConnect().createTestConnection();
    MakeOperationService makeOperationService = new MakeOperationService(testConnection, new PriceService(testConnection));
    static MakeOperation toUse = MakeOperation
            .builder()
            .operationDatetime(Instant.now())
            .idProduct(1)
            .idStation(2)
            .quantity(Double.valueOf(3))
            .build();

    @Test
    void saveInWithQuantityOk() {
        toUse.setOperationType(OperationType.OUT);
        Assertions.assertNotNull(makeOperationService.save(toUse));
    }
    @Test
    void saveInWithPriceOk() {
        MakeOperationWithPrice toUseWithPrice = new MakeOperationWithPrice();
        toUseWithPrice.setOperationType(OperationType.OUT);
        toUseWithPrice.setOperationDatetime(Instant.now());
        toUseWithPrice.setIdProduct(3);
        toUseWithPrice.setIdStation(2);
        toUseWithPrice.setPrice(Double.valueOf(5000));
        Assertions.assertNotNull(makeOperationService.save(toUseWithPrice));
    }
    @Test
    void saveOutOk() {
        toUse.setOperationType(OperationType.IN);
        toUse.setQuantity(Double.valueOf(100));
        Assertions.assertNotNull(makeOperationService.save(toUse));
    }
}
