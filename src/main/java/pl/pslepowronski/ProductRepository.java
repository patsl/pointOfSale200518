package pl.pslepowronski;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {


    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("0011", "PINK TSHIRT M-size", new BigDecimal(50)));
        products.add(new Product("0022", "BLACK TSHIRT XL-size", new BigDecimal(45)));
        products.add(new Product("0033", "Cosy socks EUR 37-42", new BigDecimal(12)));
        products.add(new Product("0044", "Socks EUR 43-47", new BigDecimal(10)));
        products.add(new Product("0055", "Navy SHORTS 5Y", new BigDecimal(40)));
        products.add(new Product("0066", "Navy SHORTS 1.5-2Y", new BigDecimal(30)));
    }


    public Optional<Product> findByBarCode(String code) {
        return products.stream().filter(product -> product.getBarCode().equals(code)).findFirst();
    }
}
