/**
 * 
 */
package master;

/**
 * @author John
 * UI portion, gets user input.  May go elsewhere or be subsumed by something else.
 */
public class POSRegister extends POSOverwatch {
	
	POSRegister(){}
	productDatabase database = new productDatabase();
	
	public void startTransaction(){
		
	}
	public void couponQuery(boolean choice){
		
	}
	public static void itemList(Items[] cart){
		for(int i = 0; i <cart.length; i++){
			System.out.println(cart[i].getItemName());
		}
		
	}
	
}
