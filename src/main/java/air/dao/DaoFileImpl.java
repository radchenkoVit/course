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

        String parent = System.getProperty("airline.input.path");

        String jsonPlaneAsString = StringUtils.loadFileIntoString(Paths.get(parent, "plane.json").toString());
        String jsonHelicopterAsString = StringUtils.loadFileIntoString(Paths.get(parent, "helicopter.json").toString());
        List<Aircraft> planes = mapper.readValue(jsonPlaneAsString, mapper.getTypeFactory().constructCollectionType(List.class, Plane.class));
        List<Aircraft> helicopters = mapper.readValue(jsonHelicopterAsString, mapper.getTypeFactory().constructCollectionType(List.class, Helicopter.class));

        planes.addAll(helicopters);
        return planes;
    }

    public boolean saveProducts(Collection<Aircraft> products) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String currentDir = System.getProperty("user.dir");
            String outputPath = Paths.get(currentDir, "aircraft.json").toString();
            mapper.writeValue(new File(outputPath), products);
            System.out.println("All aircrafts are save here: " + outputPath);
        } catch (IOException e) {
            System.out.println("Failed to save work result");
            return false;
        }

        return true;
    }
}
