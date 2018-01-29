package air.view;

import air.controller.IAirlineController;
import air.exceptions.NotFoundException;
import air.exceptions.NotValidDataException;
import air.model.Aircraft;
import air.utils.ConsoleReader;

import java.util.List;

import static air.controller.ValidationController.isValidAirCraftId;
import static air.controller.ValidationController.isValidAirCraftName;

public class FindAircraftView {
    private IAirlineController controller;
    private ConsoleReader console;

    FindAircraftView(ConsoleReader console, IAirlineController controller){
        this.console = console;
        this.controller = controller;
    }

    public void findAircraftMenu(){
        while (true) {
            displayFindMenu();
            int choice = console.readInt();
            switch (choice) {
                case 1:
                    findById();
                    break;
                case 2:
                    findByName();
                    break;
                case 9:
                    return;
                case 0:
                    System.out.println("Thank you to be with us");
                    System.exit(0);
                default:
                    System.out.println("Unknown command\n");
                    break;
            }
        }
    }

    private void displayFindMenu(){
        System.out.println("\nFind by: \n1. ID\n2. Name\n" +
                "9. Back to main menu\n0. Exit");
        System.out.print("Please, make your choice: ");
    }

    private void findById(){
        System.out.print("Enter airplane id: ");
        int id = console.readInt();

        try {
            isValidAirCraftId(id);
        } catch (NotValidDataException e){
            System.out.println("Validation is not passed, error: " + e.getMessage());
            return;
        }

        Aircraft aircraft;
        try {
            aircraft = controller.findAircraft(id);
        } catch (NotFoundException e){
            System.out.printf("Aircraft with id: %s is not found\n", id);
            return;
        }

        System.out.println("Aircrat data: " + aircraft.toString());
    }

    private void findByName(){
        System.out.print("Enter airplane name: ");
        String name = console.readLine();

        try {
            isValidAirCraftName(name);
        } catch (NotValidDataException e){
            System.out.println("Validation is not passed, error: " + e.getMessage());
            return;
        }

        List<Aircraft> aircrafts;
        try {
            aircrafts = controller.findAircraft(name);
        } catch (NotFoundException e){
            System.out.printf("Aircraft with id: %s is not found\n", name);
            return;
        }

        System.out.println("Aircrats found by name: " + aircrafts);

        for (int i = 0; i < aircrafts.size(); i++) {
            System.out.printf("%d. Aircraft - %s\n", i + 1, aircrafts.get(i).getName());
        }
    }

}
