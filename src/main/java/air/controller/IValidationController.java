package air.controller;

import air.exceptions.NotValidDataException;

public interface IValidationController {
    void isValidAirCraftName(String name) throws NotValidDataException;
    void isValidAirCraftId(int id) throws NotValidDataException;
}
