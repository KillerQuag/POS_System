package master;

import java.util.Random;

/**
 * @author John
 *  Generates a random weight for the cart presently.  Probably want to have this 
 *  value that it returns adjustable to show a discprenacy for the final show.
 *  Presently, it's just ignored.
 */

public class Scale extends ProductScanner {
	Random rnd = new Random();
	float weight = rnd.nextFloat();
}
