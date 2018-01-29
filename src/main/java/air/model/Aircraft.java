package air.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
