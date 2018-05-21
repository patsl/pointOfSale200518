package pl.pslepowronski;

import java.math.BigDecimal;
import java.util.List;

public class Printer {
    public void printReceipt(Cart cart) {
        System.out.println("RECEIPT PRINTING... PLEASE WAIT\n");
        System.out.println(cart.toString());
    }
}

