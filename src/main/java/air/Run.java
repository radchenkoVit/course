package air;

import air.controller.AirlineController;
import air.controller.IAirlineController;
import air.dao.DaoFactory;
import air.dao.DaoType;
import air.dao.IDao;
import air.model.Aircraft;
import air.utils.DataGenerator;
import air.view.AirlineView;
import air.view.IAirlineView;

import java.io.IOException;
import java.util.List;

public class Run {

    public static void main(String[] args) throws IOException {
        DataGenerator.createFakeData();
        IDao dao = DaoFactory.getInstance(DaoType.File);
        List<Aircraft> aircrafts = dao.getAll();
        IAirlineController airlineController = new AirlineController(aircrafts);

        IAirlineView application = new AirlineView(airlineController);
        application.run();

        dao.saveProducts(aircrafts);
    }

}
