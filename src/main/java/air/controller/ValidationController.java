package air.controller;

import air.Constant;

public class ValidationController {

    public static void isValidAirCraftName(String name){
        if (name.isEmpty()){
            throw new RuntimeException("Empty name");
        } else if (name.length() > 30){
            throw new RuntimeException("Too long name");
        }
    }

    public static void isValidAirCraftId(int id){
        if (id == Constant.WRONG_ENTER_CODE){
            throw new RuntimeException("Not number");
        } else if (id < 0) {
            throw new RuntimeException("Less than 0");
        }
    }
}
