package air.model;

public class UnpoweredAircraft extends Aircraft {
    protected UnpoweredAircraft(int id, String name, int passengerCapacity, int capacity, int carryingCapacity, int takeOffWeight, int maximumTakeOffWeight, int flightRange, int rangeWithMaximumLoad, int cruisingSpeed, int maximumSpeed, int maxSpeedAtHeight, int emptyWeight, int maximumHeight, int practicalRange, int practicalRangeAtHeight) {
        super(id, name, passengerCapacity, capacity, carryingCapacity, takeOffWeight, maximumTakeOffWeight, flightRange, rangeWithMaximumLoad, cruisingSpeed, maximumSpeed, maxSpeedAtHeight, emptyWeight, maximumHeight, practicalRange, practicalRangeAtHeight);
    }
}
