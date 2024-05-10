package the.station.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MakeOperationWithPrice extends MakeOperation {
    private Double price;
}
