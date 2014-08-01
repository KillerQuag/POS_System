package Tests;

import static org.junit.Assert.*;
import master.Calculations;
import master.Customer;
import master.ProductScanner;

import org.junit.Test;

public class PriceCheckCart {

	public PriceCheckCart() {
	}

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.myCart = ProductScanner.populateCart(customer.myCart);
		double totalPrice = 0;
		for (int i = 0; i < customer.myCart.numItemsInCart; i++){
			totalPrice += customer.myCart.items[i].price;
		}
		customer.myCart.myPrice = Calculations.getTotalPrice(customer.myCart);
		assertEquals(customer.myCart.myPrice, totalPrice, .0001);
	}

}
