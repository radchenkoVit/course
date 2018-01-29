package air.dao;

import air.model.Aircraft;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class DaoDBImpl implements IDao {
    @Override
    public List<Aircraft> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean saveProducts(Collection<Aircraft> aircrafts) {
        return false;
    }
}
