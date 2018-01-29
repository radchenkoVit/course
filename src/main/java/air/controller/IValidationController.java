package air.controller;

import air.exceptions.NotValidDataException;

public interface IValidationController {
    void isValidAirCraftName(String name) throws NotValidDataException;
    void isValidInteger(int id) throws NotValidDataException;
}
