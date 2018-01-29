package air.utils;

import air.model.Aircraft;
import air.model.powered.Helicopter;
import air.model.powered.Plane;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static String aircraftInputPaths = Paths.get(
            "src", "main", "resources", "data", "plane.json").toString();
    private static String helicopterInputPaths = Paths.get(
            "src", "main", "resources", "data", "helicopter.json").toString();

    public static void createFakeData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Aircraft plane = new Plane();
        plane.setId(1);
        plane.setName("Plane");
        plane.setEmptyWeight(1500);
        plane.setPassengerCapacity(34);
        plane.setCruisingSpeed(430);
        plane.setCapacity(340);

        Aircraft helicopter = new Helicopter();
        helicopter.setId(2);
        helicopter.setName("Helicopter");
        helicopter.setEmptyWeight(getRandomInt());
        helicopter.setPassengerCapacity(4);
        helicopter.setCruisingSpeed(getRandomInt());
        helicopter.setCapacity(getRandomInt());

        List<Aircraft> planeList = new ArrayList<>();
        List<Aircraft> helicopterList = new ArrayList<>();
        planeList.add(plane);
        helicopterList.add(helicopter);

        for (int i = 3; i < 16; i++){
            planeList.add(generateRandomAirCraft(i));
        }

        for (int i = 16; i < 21; i++){
            helicopterList.add(generateRandomHelicopter(i));
        }

        mapper.writeValue(new File(aircraftInputPaths), planeList);
        mapper.writeValue(new File(helicopterInputPaths), helicopterList);
    }


    private static Aircraft generateRandomAirCraft(int nextId){
        Aircraft plane = new Plane();

        plane.setId(nextId);
        plane.setName("Plane " + getRandomString());
        plane.setEmptyWeight(getRandomInt());
        plane.setPassengerCapacity(getRandomInt());
        plane.setCruisingSpeed(getRandomInt());
        plane.setCapacity(getRandomInt());
        plane.setFlightRange(getRandomInt());
        plane.setMaximumHeight(getRandomInt());

        return plane;
    }

    private static Aircraft generateRandomHelicopter(int nextId){
        Aircraft plane = new Helicopter();

        plane.setId(nextId);
        plane.setName("Helicopter " + getRandomString());
        plane.setEmptyWeight(getRandomInt());
        plane.setPassengerCapacity(4);
        plane.setCruisingSpeed(getRandomInt());
        plane.setCapacity(getRandomInt());
        plane.setFlightRange(getRandomInt());
        plane.setMaximumHeight(getRandomInt());

        return plane;
    }

    private static String getRandomString(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789_".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString().trim();
    }

    private static int getRandomInt(){
        return new Random().nextInt(3000);
    }
}
