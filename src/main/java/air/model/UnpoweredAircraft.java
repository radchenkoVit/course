package air.model;

public abstract class UnpoweredAircraft extends Aircraft {
    public UnpoweredAircraft(){
        super();
        isPowered = false;
    }
}
