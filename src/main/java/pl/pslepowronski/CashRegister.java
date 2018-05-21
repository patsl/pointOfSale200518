package pl.pslepowronski;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class CashRegister {
    BarCodeScanner barCodeScanner = new BarCodeScanner();
    ProductRepository productRepository = new ProductRepository();
    LcdDisplay display = new LcdDisplay();
    Cart cart = new Cart();
    Scanner in = new Scanner(System.in);
    Printer printer = new Printer();

    public void start() {

        System.out.println("Welcome, please ready your buys.\n");
        String readCode;
        String endOfScan = "";

        while (endOfScan.hashCode() != "E".hashCode()) {
            readCode = barCodeScanner.readBarCode();
            checkBarCode(readCode);
            System.out.println("Press E to print receipt or other button to scan next thing.");
            endOfScan = in.nextLine();
            endOfScan = endOfScan.toUpperCase();
        }
        BigDecimal totalPrice = cart.totalPriceFromCart();
        display.displayMessage("Total price " + totalPrice + " PLN \n");
        printer.printReceipt(cart);
    }

    public Cart checkBarCode(String readCode) {//wydzielona tylko dla przejrzystszego testowania.
        Product product;
        if (readCode.equals("")) {
            display.displayMessage("Invalid bar-code \n");
        } else {
            Optional<Product> optionalProduct = productRepository.findByBarCode(readCode);
            if (optionalProduct.isPresent()) {
                product = optionalProduct.get();
                display.displayMessage(product.getName() + ", " + product.getPrice() + " PLN \n");
                cart.addToCart(product);
            } else {
                display.displayMessage("Product not found \n");
            }
        }
        return cart;
    }


}
