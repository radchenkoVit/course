package air.dao;

import air.model.Aircraft;
import air.model.powered.Helicopter;
import air.model.powered.Plane;
import air.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class DaoFileImpl implements IDao {
    private static String planeInputPaths = Paths.get(
            "src", "main", "resources", "data", "plane.json").toString();
    private static String helicopterInputPaths = Paths.get(
            "src", "main", "resources", "data", "helicopter.json").toString();
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

        String jsonPlaneAsString = StringUtils.loadFileIntoString(planeInputPaths);
        String jsonHelicopterAsString = StringUtils.loadFileIntoString(helicopterInputPaths);
        List<Aircraft> planes = mapper.readValue(jsonPlaneAsString, mapper.getTypeFactory().constructCollectionType(List.class, Plane.class));
        List<Aircraft> helicopters = mapper.readValue(jsonHelicopterAsString, mapper.getTypeFactory().constructCollectionType(List.class, Helicopter.class));

        planes.addAll(helicopters);
        return planes;
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
