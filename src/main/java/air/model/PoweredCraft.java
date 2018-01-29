package air.model;

import java.util.Objects;

public abstract class PoweredCraft extends Aircraft {
    protected boolean withEngine;

    public PoweredCraft(){
        super();
        isPowered = true;
    }

    public boolean isWithEngine() {
        return withEngine;
    }

    public void setWithEngine(boolean withEngine) {
        this.withEngine = withEngine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PoweredCraft that = (PoweredCraft) o;
        return withEngine == that.withEngine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), withEngine);
    }
}
