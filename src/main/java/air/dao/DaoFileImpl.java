package air.dao;

import air.model.Aircraft;
import air.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class DaoFileImpl implements IDao {
    private static String aircraftInputPaths = Paths.get(
            "src", "main", "resources", "data", "aircraft.json").toString();
    private static String aircraftOutputPaths = Paths.get(
            "src", "main", "resources", "data", "output", "result_aircraft.json").toString();

    private static IDao dao;

    private DaoFileImpl(){
    }

    public static IDao getDao(){
        if (dao == null){
            dao = new DaoFileImpl();
        }
        return dao;
    }

    public List<Aircraft> getAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonAircraftAsString = StringUtils.loadFileIntoString(aircraftInputPaths);
        List<Aircraft> aircrafts = mapper.readValue(jsonAircraftAsString, mapper.getTypeFactory().constructCollectionType(List.class, Aircraft.class));

        return aircrafts;
    }

    public boolean saveProducts(Collection<Aircraft> products) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(aircraftOutputPaths), products);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
