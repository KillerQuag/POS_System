package master;
/*Trial container class to save the information in a cart in order for other classes to have
 * a readily available copy of it
 * currently doesn't work ~Matt
*/
public class CartStorage{
	private Cart saved;
	
	public void save(Cart c){
		saved = c;
	}
	
	public Cart getCart(){
		return saved;
	}

}
