package air.controller;

import air.model.Aircraft;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AirlineController {
    private List<Aircraft> aircrafts;

    public AirlineController(List<Aircraft> aircrafts){
        this.aircrafts = aircrafts;
    }

    public int nextId(){
        return aircrafts.size() + 1;
    }

    public boolean add(Aircraft aircraft){
        return aircrafts.add(aircraft);
    }

    public List<Aircraft> sortByPassengerCapacity(){
        aircrafts.sort(Comparator.comparingInt(Aircraft::getPassengerCapacity));
        return aircrafts;
    }
    public List<Aircraft> sortByFlightRange(){
        aircrafts.sort(Comparator.comparingInt(Aircraft::getFlightRange));
        return aircrafts;
    }

    public List<Aircraft> sortByCarryingCapacity(){
        aircrafts.sort(Comparator.comparingInt(Aircraft::getCarryingCapacity));
        return aircrafts;
    }

    public List<Aircraft> filterByFlightRange(int start, int end){
        return aircrafts.stream().filter(craft -> craft.getFlightRange() >= start && craft.getFlightRange() <=end)
                .collect(Collectors.toList());
    }

    public Aircraft findAircraft(int id){
        Optional<Aircraft> aircraft = aircrafts.stream().filter(craft -> craft.getId() == id).findFirst();
        if (aircraft != null && aircraft.isPresent()){
            return aircraft.get();
        }

        throw new RuntimeException("Not found aircraft exception");
    }

    public List<Aircraft> findAircraft(String name){
        List<Aircraft> list = aircrafts.stream().filter(craft -> craft.getName().contains(name)).collect(Collectors.toList());
        if (list.isEmpty()){
            throw new RuntimeException("Not found aircraft exception");
        }

        return list;
    }

    public String displayListOfCraft(){
        StringBuilder builder = new StringBuilder();
        aircrafts.forEach(craft -> builder.append(craft.toString()).append("\n"));
        return builder.toString();
    }

    public int getTotalCapacity(){
        return aircrafts.stream().mapToInt(Aircraft::getCapacity).sum();
    }

    public int getCarryingCapacity(){
        return aircrafts.stream().mapToInt(Aircraft::getCarryingCapacity).sum();
    }
}
