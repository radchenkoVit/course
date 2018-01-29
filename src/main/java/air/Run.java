package air;

import air.controller.AirlineController;
import air.dao.DaoImpl;
import air.model.Aircraft;
import air.view.AirlineView;
import air.view.IAirlineView;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Run {

    public static void main(String[] args) throws IOException {
        DaoImpl.createFakeData(); //createFakeData
        DaoImpl dao = new DaoImpl();
        List<Aircraft> aircrafts = dao.getAll();
        AirlineController airlineController = new AirlineController(aircrafts);

        IAirlineView application = new AirlineView(airlineController);
        application.run();

        dao.saveProducts(aircrafts);
    }

}
