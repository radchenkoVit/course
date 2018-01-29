package air.dao;

import air.model.Aircraft;
import air.model.powered.JetAircraft;
import air.model.powered.Plane;
import air.model.powered.PropellerAircraft;
import air.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DaoImpl {
    private static String aircraftInputPaths = Paths.get(
            "src", "main", "resources", "data", "aircraft.json").toString();
    private static String aircraftOutputPaths = Paths.get(
            "src", "main", "resources", "data", "output", "result_aircraft.json").toString();

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

    public static void createFakeData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Aircraft plane = Plane.builder().id(0).name("PlaneName")
                .emptyWeight(1500).passengerCapacity(34).cruisingSpeed(430)
                .capacity(340).flightRange(2500).maximumHeight(3500).build();

        Aircraft plane2 = JetAircraft.builder().id(0).name("Koteika")
                .emptyWeight(1500).passengerCapacity(34).cruisingSpeed(430)
                .capacity(340).flightRange(2500).maximumHeight(3500).build();

        Aircraft plane3 = PropellerAircraft.builder().id(0).name("Koteika 2")
                .emptyWeight(150).passengerCapacity(324).cruisingSpeed(2423)
                .capacity(340).flightRange(1).maximumHeight(42).build();

        List<Aircraft> list = Arrays.asList(plane, plane2, plane3);

        mapper.writeValue(new File(aircraftInputPaths), list);
    }
}
