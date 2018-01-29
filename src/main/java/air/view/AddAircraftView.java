package air.view;

import air.controller.IAirlineController;
import air.controller.IValidationController;
import air.controller.ValidationController;
import air.exceptions.NotValidDataException;
import air.model.Aircraft;
import air.model.powered.Plane;
import air.utils.ConsoleReader;

public class AddAircraftView {
    private IAirlineController controller;
    private IValidationController validationController;
    private ConsoleReader console;

    public AddAircraftView(ConsoleReader console, IAirlineController controller) {
        this.controller = controller;
        this.console = console;
        validationController = new ValidationController();
    }

    public void run(){
        System.out.print("Add aircraft data.\nWrite name: ");
        String name = console.readLine();

        System.out.print("Write carrying capacity: ");
        int carryingCapacity = console.readInt();
        try {
            validationController.isValidInteger(carryingCapacity);

            Aircraft aircraft = new Plane();
                    aircraft.setId(controller.nextId());
                    aircraft.setName(name);
                    aircraft.setCarryingCapacity(carryingCapacity);

            if (controller.add(aircraft)){
                System.out.printf("\nAircraft %s is added\n", name);
            } else {
                System.out.printf("\nAircraft %s failed to add\n", name);
            }
        } catch (NotValidDataException e){
                System.out.printf("Aircraft %s failed to add, exception: %s\n", name, e.getMessage());
        }
    }
}
