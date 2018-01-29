package air.view;

import air.controller.AirlineController;
import air.model.Aircraft;
import air.utils.ConsoleReader;

import java.util.List;

public class AirlineView implements IAirlineView {
    private AirlineController controller;
    private ConsoleReader console;

    private FindAircraftView findAircraftView;
    private SortView sortView;

    public AirlineView(AirlineController controller){
        console = new ConsoleReader();
        this.controller = controller;
        findAircraftView = new FindAircraftView(console, controller);
        sortView = new SortView(console, controller);
    }

    @Override
    public void run() {
        int choice = -1;
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
                case 6:
                    //TODO:
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

    private void sort() {
        sortView.displayByFlightRange();
    }

    private void calculateTotalCapacity(){
        System.out.println("Total capacity is: " + controller.getTotalCapacity());
        System.out.println("Total carrying capacity is: " + controller.getCarryingCapacity());
    }

    private void displayListOfAircraft(){
        System.out.println(controller.displayListOfCraft());
    }

    private void sortAirPlanes(){
        sortView.sortMenu();
    }

    private void displayMainMenu(){
        System.out.println("\nEnter the next action:" +
                "\n1. Calculate capacity" +
                "\n2. Display all aircraft's" +
                "\n3. Find aircraft" +
                "\n4. Display aircraft by flight range" +
                "\n5. Sort aircraft's" +
                "\n6. Add aircraft" +
                "\n7. Filter by range" +
                "\n0. Exit\n");
    }

    private int userChoice(){
        System.out.print("\nPlease, make your choice: ");
        return console.readInt();
    }
}
