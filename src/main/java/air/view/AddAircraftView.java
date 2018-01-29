package air.view;

import air.controller.IAirlineController;
import air.model.Aircraft;
import air.model.powered.Plane;
import air.utils.ConsoleReader;

public class AddAircraftView {
    private IAirlineController controller;
    private ConsoleReader console;

    public AddAircraftView(ConsoleReader console, IAirlineController controller) {
        this.controller = controller;
        this.console = console;
    }

    public void run(){
        System.out.println("Add aircraft data: ");
        System.out.println("Add name :");
        String name = console.readLine();

        System.out.println("Type carrying capacity");
        int carryingCapacity = console.readInt();

        Aircraft aircraft = new Plane();
                aircraft.setId(controller.nextId());
                aircraft.setName(name);
                aircraft.setCarryingCapacity(carryingCapacity);

        if (controller.add(aircraft)){
            System.out.println("Was added");
        } else {
            System.out.println("Failed to add");
        }
    }
}
