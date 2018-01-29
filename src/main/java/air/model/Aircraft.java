package air.model;

import java.util.Objects;

public abstract class Aircraft {
    private int id;
    private String name;

    private int passengerCapacity;
    private int capacity; // => enginePower;
    private int carryingCapacity;

    //technical characteristic
    private int takeOffWeight;
    private int maximumTakeOffWeight;

    private int flightRange;
    private int rangeWithMaximumLoad;

    private int cruisingSpeed;
    private int maximumSpeed;
    private int maxSpeedAtHeight;

    private int emptyWeight;
    private int maximumHeight;

    private int practicalRange;
    private int practicalRangeAtHeight;
    public boolean isPowered;

    public Aircraft() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getTakeOffWeight() {
        return takeOffWeight;
    }

    public void setTakeOffWeight(int takeOffWeight) {
        this.takeOffWeight = takeOffWeight;
    }

    public int getMaximumTakeOffWeight() {
        return maximumTakeOffWeight;
    }

    public void setMaximumTakeOffWeight(int maximumTakeOffWeight) {
        this.maximumTakeOffWeight = maximumTakeOffWeight;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public int getRangeWithMaximumLoad() {
        return rangeWithMaximumLoad;
    }

    public void setRangeWithMaximumLoad(int rangeWithMaximumLoad) {
        this.rangeWithMaximumLoad = rangeWithMaximumLoad;
    }

    public int getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(int cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getMaxSpeedAtHeight() {
        return maxSpeedAtHeight;
    }

    public void setMaxSpeedAtHeight(int maxSpeedAtHeight) {
        this.maxSpeedAtHeight = maxSpeedAtHeight;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(int emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public int getMaximumHeight() {
        return maximumHeight;
    }

    public void setMaximumHeight(int maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    public int getPracticalRange() {
        return practicalRange;
    }

    public void setPracticalRange(int practicalRange) {
        this.practicalRange = practicalRange;
    }

    public int getPracticalRangeAtHeight() {
        return practicalRangeAtHeight;
    }

    public void setPracticalRangeAtHeight(int practicalRangeAtHeight) {
        this.practicalRangeAtHeight = practicalRangeAtHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return id == aircraft.id &&
                passengerCapacity == aircraft.passengerCapacity &&
                capacity == aircraft.capacity &&
                carryingCapacity == aircraft.carryingCapacity &&
                takeOffWeight == aircraft.takeOffWeight &&
                maximumTakeOffWeight == aircraft.maximumTakeOffWeight &&
                flightRange == aircraft.flightRange &&
                rangeWithMaximumLoad == aircraft.rangeWithMaximumLoad &&
                cruisingSpeed == aircraft.cruisingSpeed &&
                maximumSpeed == aircraft.maximumSpeed &&
                maxSpeedAtHeight == aircraft.maxSpeedAtHeight &&
                emptyWeight == aircraft.emptyWeight &&
                maximumHeight == aircraft.maximumHeight &&
                practicalRange == aircraft.practicalRange &&
                practicalRangeAtHeight == aircraft.practicalRangeAtHeight &&
                Objects.equals(name, aircraft.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passengerCapacity, capacity, carryingCapacity, takeOffWeight, maximumTakeOffWeight, flightRange, rangeWithMaximumLoad, cruisingSpeed, maximumSpeed, maxSpeedAtHeight, emptyWeight, maximumHeight, practicalRange, practicalRangeAtHeight);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", Name ='" + name + '\'' +
                ", Passenger Capacity=" + passengerCapacity +
                ", Carrying Capacity=" + carryingCapacity +
                ", Take Off Weight=" + takeOffWeight +
                ", Flight Range=" + flightRange +
                ", Maximum Speed=" + maximumSpeed +
                '}';
    }
}
