package master;

import java.util.Random;

/**
 * @author John
 *  Generates a random weight for the cart presently.  Probably want to have this 
 *  value that it returns adjustable to show a discprenacy for the final show.
 *  Presently, it's just ignored.
 */

public class Scale {
	Random rnd = new Random();
	int rand = rnd.nextInt(100);
	float weight;
	
	public Scale(){
		
	}
	
	public boolean error (){
		boolean failed = false;
		
		if (rand >= 90)
			failed = true;
		
		return failed;
	}
}
