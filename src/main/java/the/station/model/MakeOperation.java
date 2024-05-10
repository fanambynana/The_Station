package the.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import the.station.model.Enum.OperationType;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MakeOperation {
    private Integer idMakeOperation;
    private Integer idProduct;
    private Integer idStation;
    private Double quantity;
    private OperationType operationType;
    private Instant operationDatetime;
}
