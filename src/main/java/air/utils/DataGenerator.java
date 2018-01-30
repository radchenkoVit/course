package air.utils;

import air.Constant;
import air.model.Aircraft;
import air.model.powered.Helicopter;
import air.model.powered.Plane;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

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

        Path parent = Files.createTempDirectory(Constant.INPUT_PATH);

        mapper.writeValue(new File(parent.toString(), "plane.json"), planeList);
        mapper.writeValue(new File(parent.toString(), "helicopter.json"), helicopterList);

        System.setProperty("airline.input.path", parent.toString());
    }


    private static Aircraft generateRandomAirCraft(int nextId){
        Aircraft plane = new Plane();

        plane.setId(nextId);
        plane.setName("Plane " + getRandomString());
        plane.setEmptyWeight(getRandomInt());
        plane.setPassengerCapacity(getRandomInt());
        plane.setCruisingSpeed(getRandomInt());
        plane.setCapacity(getRandomInt());
        plane.setCarryingCapacity(getRandomInt());
        plane.setFlightRange(getRandomInt());
        plane.setFlightRange(getRandomInt());
        plane.setMaximumHeight(getRandomInt());

        return plane;
    }

    private static Aircraft generateRandomHelicopter(int nextId){
        Aircraft helicopter = new Helicopter();

        helicopter.setId(nextId);
        helicopter.setName("Helicopter " + getRandomString());
        helicopter.setEmptyWeight(getRandomInt());
        helicopter.setPassengerCapacity(4);
        helicopter.setCruisingSpeed(getRandomInt());
        helicopter.setCarryingCapacity(getRandomInt());
        helicopter.setCapacity(getRandomInt());
        helicopter.setFlightRange(getRandomInt());
        helicopter.setFlightRange(getRandomInt());
        helicopter.setMaximumHeight(getRandomInt());

        return helicopter;
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
