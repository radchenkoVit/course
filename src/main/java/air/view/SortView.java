package air.view;

import air.controller.AirlineController;
import air.model.Aircraft;
import air.utils.ConsoleReader;

import java.util.List;

public class SortView {
    private AirlineController controller;
    private ConsoleReader console;

    public SortView(ConsoleReader console, AirlineController controller){
        this.console = console;
        this.controller = controller;
    }

    public void sortMenu(){
        while (true){
            int choice = displaySortMenu();
            switch (choice){
                case 1:
                    displayByFlightRange();
                    break;
                case 2:
                    displayByCarryingCapacity();
                    break;
                case 3:
                    displayByPassengerCapacity();
                    break;
                case 9:
                    return;
                case 0:
                    System.out.println("Thank you to be with us");
                    System.exit(0);
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private int displaySortMenu() {
        System.out.println("Choose field that you would like sort by:\n" +
                "1. Flight Range\n2. Carrying Capacity\n3. Passenger Capacity\n" +
                "9. Back to prev menu\n0. Exit");

        System.out.print("\nPlease, make your choice: ");
        return console.readInt();
    }

    public void displayByFlightRange(){
        List<Aircraft> sorted =  controller.sortByFlightRange();
        displayAirCrafts(sorted);
    }

    private void displayByCarryingCapacity(){
        List<Aircraft> sorted =  controller.sortByCarryingCapacity();
        displayAirCrafts(sorted);
    }

    private void displayByPassengerCapacity(){
        List<Aircraft> sorted =  controller.sortByPassengerCapacity();
        displayAirCrafts(sorted);
    }

    private static void displayAirCrafts(List<Aircraft> list){
        list.forEach(System.out::println);
        System.out.println();
    }
}
