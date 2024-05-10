package the.station.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.station.model.Product;
import the.station.model.Evaporation;
import the.station.model.MakeOperation;
import the.station.model.Price;
import the.station.model.Station;

@NoArgsConstructor
@Data
public class GenericModel {
    private Product product = new Product();
    private MakeOperation makeOperation = new MakeOperation();
    private Station station = new Station();
    private Evaporation evaporation = new Evaporation();
    private Price price = new Price();
}
