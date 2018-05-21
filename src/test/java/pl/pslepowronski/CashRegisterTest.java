package pl.pslepowronski;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CashRegisterTest {

    List<Product> list;
    String barCode;
    CashRegister cashRegister;

    @Before
    public void setUp() {
        cashRegister = new CashRegister();
    }


    @Test
    public void shouldNotAddProductIfBarCodeIsWrong() {
        cashRegister.productRepository = mock(ProductRepository.class);
        when(cashRegister.productRepository.findByBarCode(Matchers.anyString())).thenReturn(Optional.empty());
        barCode = "0011";
        cashRegister.checkBarCode(barCode);
        list = cashRegister.cart.getCartItems();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldNotAddProductIfBarCodeIsEmpty() {
        barCode = "";
        cashRegister.checkBarCode(barCode);
        list = cashRegister.cart.getCartItems();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldAddProductIfFoundBarCode() {
        barCode = "0123";
        Product product1 = new Product("0123", "PS4 PRO", new BigDecimal(1599));
        cashRegister.productRepository = mock(ProductRepository.class);
        Optional<Product> optionalProduct = Optional.ofNullable(product1);
        when(cashRegister.productRepository.findByBarCode(barCode)).thenReturn(optionalProduct);
        cashRegister.checkBarCode(barCode);
        list = cashRegister.cart.getCartItems();
        Assert.assertTrue(list.contains(product1)&&list.size()==1);
    }
}