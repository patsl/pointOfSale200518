package pl.pslepowronski;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addToCart(Product product) {
        cartItems.add(product);
    }

    public BigDecimal totalPriceFromCart() {
        return cartItems.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, (sum, price) -> sum.add(price));
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        String result = "";
        int i = 1;
        for (Product p : cartItems) {
            result = result + i + ". " + p.getName() + "  " + p.getPrice() + " PLN\n";
            i++;
        }
        result = result + "\nTotal price:     " + totalPriceFromCart() + " PLN\n";
        return result;
    }
}