package air.controller;

import air.Constant;
import air.exceptions.NotValidDataException;

public class ValidationController implements IValidationController {

    public void isValidAirCraftName(String name) throws NotValidDataException {
        if (name.isEmpty()){
            throw new NotValidDataException("Empty name");
        } else if (name.length() > 30){
            throw new NotValidDataException("Too long name");
        }
    }

    public void isValidAirCraftId(int id) throws NotValidDataException {
        if (id == Constant.WRONG_ENTER_CODE){
            throw new NotValidDataException("Not number");
        } else if (id < 0) {
            throw new NotValidDataException("Less than 0");
        }
    }
}
