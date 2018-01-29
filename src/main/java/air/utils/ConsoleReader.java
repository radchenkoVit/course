package air.utils;

import air.Constant;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner console = new Scanner(System.in);

    public String readLine(){
        return console.next();
    }

    public int readInt() {
        try {
            String raw = console.next();
            return Integer.parseInt(raw);
        } catch (NumberFormatException e){
            return Constant.WRONG_ENTER_CODE;
        }
    }
}
