package pl.pslepowronski;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class CartTest {

    Product product1;
    Product product2;
    Product product3;
    Cart cart;
    List<Product> list;

    @Before
    public void setUp(){
        product1 = new Product("0123", "PS4 PRO", new BigDecimal(1599));
        product2 = new Product("0223", "FIFA18 PS4", new BigDecimal(199));
        product3 = new Product("0423", "GOD OF WAR PS4", new BigDecimal(249));
        cart = new Cart();
        list = cart.getCartItems();
    }

    @Test
    public void shouldAddToCartNewProduct() {

        Assert.assertTrue(list.isEmpty());
        cart.addToCart(product1);
        Assert.assertTrue(list.size()==1 && list.contains(product1));
    }

    @Test
    public void shouldCountPriceForAllGoodsInCart() {

        cart.addToCart(product1);
        Assert.assertEquals(cart.totalPriceFromCart(), product1.getPrice());
        cart.addToCart(product2);
        cart.addToCart(product3);
        Assert.assertEquals(cart.totalPriceFromCart(), product1.getPrice().add(product2.getPrice()).add(product3.getPrice()));

    }
}