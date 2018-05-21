package pl.pslepowronski;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {

    ProductRepository productRepository;
    Product product;
    Optional<Product> optionalProduct;

    @Before
    public void setUp(){
        product = new Product("0123", "PS4 PRO", new BigDecimal(1599));
        optionalProduct = Optional.ofNullable(product);
        productRepository = mock(ProductRepository.class);
    }

    @Test
    public void shouldFindProductByBarCode(){
        when(productRepository.findByBarCode(product.getBarCode())).thenReturn(optionalProduct);
        Product findingProduct = productRepository.findByBarCode(product.getBarCode()).get();
        Assert.assertEquals(findingProduct, product);
    }

    @Test
    public void shouldFindEmptyOptionalIfNotFoundBarCode(){
        when(productRepository.findByBarCode("0111")).thenReturn(Optional.empty());
        optionalProduct = productRepository.findByBarCode("0111");
        Assert.assertFalse(optionalProduct.isPresent());
    }
}