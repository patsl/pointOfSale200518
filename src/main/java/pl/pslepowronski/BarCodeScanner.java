package pl.pslepowronski;

import java.util.Scanner;

public class BarCodeScanner {

    public String readBarCode() {
        System.out.println("Bar Code Scanner error. Please input code manually:");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}