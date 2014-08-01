package Tests;

import static org.junit.Assert.*;
import master.Customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmptyCustomer {

	public EmptyCustomer() {
	}

	@Test
	public void test() {
		Customer customer = new Customer();
		assertTrue(customer.amountPaid == 0);
		assertTrue(customer.amountReturned == 0);
		assertTrue(customer.changeDue == 0);
		assertTrue(customer.giftCardBalance == 0);
		assertTrue(customer.remainingBalance == 0);	
	}

}
