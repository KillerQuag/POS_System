package master;

import java.util.Random;

//AJV
//Generates a random floating value for the weight of the cart.

public class Scale extends ProductScanner {
	Random rnd = new Random();
	float weight = rnd.nextFloat();
}
