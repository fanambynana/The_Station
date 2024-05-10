package the.station.repository;

import java.util.List;

public interface CrudOperation<T> {
    T save(T toSave);
    boolean deleteById(int id);
    T update(T toUpdate);
    List<T> findAll();
    T findById(Integer id);
    List<T> findCustom(List<KeyAndValue> keyAndValueList);
}
