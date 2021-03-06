package air.view;

import air.controller.IAirlineController;
import air.model.Aircraft;
import air.utils.ConsoleReader;

import java.util.List;

public class AirlineView implements IAirlineView {
    private IAirlineController controller;
    private ConsoleReader console;

    private FindAircraftView findAircraftView;
    private SortView sortView;
    private AddAircraftView addAircraftView;

    public AirlineView(IAirlineController controller){
        console = new ConsoleReader();
        this.controller = controller;
        findAircraftView = new FindAircraftView(console, controller);
        sortView = new SortView(console, controller);
        addAircraftView = new AddAircraftView(console, controller);
    }

    @Override
    public void run() {
        int choice = -1;
        System.out.println("\nWelcome to Aircraft app, version 1.0.0. Powered By Test Task from Global Logic");
        while (choice != 0){
            displayMainMenu();
            choice = userChoice();
            switch (choice) {
                case 1:
                    calculateTotalCapacity();
                    break;
                case 2:
                    displayListOfAircraft();
                    break;
                case 3:
                    findAircraftView.findAircraftMenu();
                    break;
                case 4:
                    sortView.displayByFlightRange();
                    break;
                case 5:
                    sortView.sortMenu();
                    break;
                case 6:
                    addAircraftView.run();
                    break;
                case 7:
                    filterByFlightRange();
                    break;
                case 0:
                    System.out.println("Thank to be with us");
                    break;
                default:
                    System.out.print("Unknown command\n");
                    break;
            }
        }
    }

    private void filterByFlightRange() {
        System.out.print("Enter begin range: ");
        int startRange = console.readInt();
        System.out.print("Enter end range: ");
        int endRange = console.readInt();

        List<Aircraft> filtered = controller.filterByFlightRange(startRange, endRange);
        System.out.println("Filter Result: ");
        filtered.forEach(System.out::println);
        System.out.println();
    }

    private void calculateTotalCapacity(){
        System.out.printf("Total capacity is: %s tons\n", controller.getTotalCapacity());
        System.out.printf("Total carrying capacity is: %s tons\n", controller.getCarryingCapacity());
    }

    private void displayListOfAircraft(){
        System.out.println(controller.getAllAsString());
    }

    private void displayMainMenu(){
        System.out.println("\nEnter the next action:" +
                "\n     1. Calculate capacity" +
                "\n     2. Display all aircraft's" +
                "\n     3. Find aircraft" +
                "\n     4. Display aircraft by flight range" +
                "\n     5. Sort aircraft's" +
                "\n     6. Add aircraft" +
                "\n     7. Filter by range" +
                "\n     0. Exit\n");
    }

    private int userChoice(){
        System.out.print("\nPlease, make your choice: ");
        return console.readInt();
    }
}
