package air.dao;

import air.model.Aircraft;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface IDao {

    List<Aircraft> getAll() throws IOException;

    boolean saveProducts(Collection<Aircraft> aircrafts);
}
