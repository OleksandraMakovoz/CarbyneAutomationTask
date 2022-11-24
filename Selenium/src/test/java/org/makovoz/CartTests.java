package org.makovoz;

import org.makovoz.pages.Cart;
import org.makovoz.pages.HomePage;
import org.makovoz.pages.ProductDetailsPage;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTest {
    private final HomePage homePage = new HomePage();

    @Test
    public void cartTest() throws InterruptedException {
        String[] names = new String[] {"Samsung galaxy s6", "HTC One M9"};
        List<Integer> prices = new LinkedList<>();
        for (String name : names) {
            ProductDetailsPage pdp = homePage
                    .openProductDetailsPage(name);
            prices.add(pdp.getPrice());
            pdp.addProductToCart()
                    .navigateBack()
                    .navigateBack();
        }
        int sum = prices.stream().reduce(0, Integer::sum);

        Cart cart = homePage.getHeader()
                .openCart();

        assertEquals(cart.getTotal(), sum);

        int count = cart.getProducts().size();
        for (int i = count; i > 0; i--) {
            cart.getProducts().getLast().deleteProduct();
        }
        assertEquals(cart.getProductsCount(), 0);
    }
}
