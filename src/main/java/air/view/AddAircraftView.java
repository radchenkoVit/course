package air.view;

import air.controller.AirlineController;
import air.model.Aircraft;
import air.utils.ConsoleReader;

public class AddAircraftView {
    private AirlineController controller;
    private ConsoleReader console;

    public AddAircraftView(ConsoleReader console, AirlineController controller) {
        this.controller = controller;
        this.console = console;
    }

    public void run(){
        System.out.println("Add aircraft data: ");
        System.out.println("Add name :");
        String name = console.readLine();

        System.out.println("Type carrying capacity");
        int carryingCapacity = console.readInt();

        Aircraft aircraft = Aircraft.builder()
                .id(controller.nextId())
                .name(name)
                .carryingCapacity(carryingCapacity).build();

        if (controller.add(aircraft)){
            System.out.println("Was added");
        } else {
            System.out.println("Failed to add");
        }
    }
}
