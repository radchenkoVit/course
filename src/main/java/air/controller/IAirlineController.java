package air.controller;

import air.exceptions.NotFoundException;
import air.model.Aircraft;

import java.util.List;

public interface IAirlineController {

    int nextId();
    boolean add(Aircraft aircraft);
    List<Aircraft> sortByPassengerCapacity();
    List<Aircraft> sortByFlightRange();
    List<Aircraft> sortByCarryingCapacity();
    List<Aircraft> filterByFlightRange(int start, int end);
    Aircraft findAircraft(int id) throws NotFoundException;
    List<Aircraft> findAircraft(String name) throws NotFoundException;
    String getAllAsString();
    int getTotalCapacity();
    int getCarryingCapacity();
}
