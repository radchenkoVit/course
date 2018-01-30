package air.dao;

import air.model.Aircraft;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class DaoDBImpl implements IDao {
    private static IDao dao;

    private DaoDBImpl(){
    }

    public static IDao getDao(){
        if (dao == null){
            dao = new DaoDBImpl();
        }
        return dao;
    }

    @Override
    public List<Aircraft> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean saveProducts(Collection<Aircraft> aircrafts) {
        return false;
    }
}
