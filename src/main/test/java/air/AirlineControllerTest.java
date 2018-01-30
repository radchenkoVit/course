package air;

import air.controller.AirlineController;
import air.controller.IAirlineController;
import air.exceptions.NotFoundException;
import air.model.Aircraft;
import air.model.powered.Helicopter;
import air.model.powered.Plane;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AirlineControllerTest {
    private List<Aircraft> aircrafts = mock(List.class);

    @Test
    public void validateNextIDTest(){
        IAirlineController controller = new AirlineController(aircrafts);
        when(aircrafts.size()).thenReturn(5);

        Assert.assertEquals("NextId is not correct",6, controller.nextId());
    }

    @Test
    public void filterControllerTest(){
        IAirlineController controller = new AirlineController(Arrays.asList(getPlane(), getHelicopter()));
        List<Aircraft> actualList = controller.filterByFlightRange(0, 1000);

        Assert.assertEquals(Arrays.asList(getHelicopter()), actualList);
    }

    @Test(expected = NotFoundException.class)
    public void findTest() throws NotFoundException {
        IAirlineController controller = new AirlineController(Arrays.asList(getPlane(), getHelicopter()));
        controller.findAircraft("NotNameExists");
    }

    private static Aircraft getPlane(){
        Aircraft plane = new Plane();
        plane.setId(1);
        plane.setName("Plane");
        plane.setFlightRange(5000);
        plane.setEmptyWeight(1500);
        plane.setPassengerCapacity(34);
        plane.setCruisingSpeed(430);
        plane.setCapacity(340);

        return plane;
    }


    public static Aircraft getHelicopter() {
        Aircraft helicopter = new Helicopter();
        helicopter.setId(2);
        helicopter.setName("Helicopter");
        helicopter.setFlightRange(700);
        helicopter.setEmptyWeight(1200);
        helicopter.setPassengerCapacity(4);
        helicopter.setCruisingSpeed(34);
        helicopter.setCapacity(430);

        return helicopter;
    }
}
