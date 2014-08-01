package Tests;

import static org.junit.Assert.*;
import master.Customer;
import master.Scale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScaleException {

	public ScaleException() {
	}

	@Test
	public void test() {
		Customer customer = new Customer();
		boolean weightError = true;
		
		for (int i = 0; i < 100; i++)
			if (new Scale().error())
				weightError = false;
		
		assertTrue(!weightError);
	}

}
