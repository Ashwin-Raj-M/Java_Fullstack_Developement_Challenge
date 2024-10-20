/***
 * There are three types of interfaces:
 * 	1 -> Normal Interface --> has more than one abstract methodes
 * 	2 -> Functional Interface --> has only one abstract methodes
 * 	3 -> Marker Interface --> has no methodes
 * 
 * Functional Interfaces are also called as SAM Interfaces (Single Abstract Method)
 * Functional interfaces got a new feature added in Java 8,
 * which is lambda functions (only wirks with Functional Interfaces).
 * 
 * @author ashwi
 *
 */

@FunctionalInterface
interface FunInter{
	void show();
}

public class Functional_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		usually we use Anonymous Inner class to override the methodes of abstract class or interface 
		FunInter obj = new FunInter() {
			public void show() {
				System.out.println("Shows");
			}
		};
		
//		this could be writtern more effeciently and shorter using lambda expresssions
//		this is to make sure that java is no more verbose
//		(verbose = Elobarately and clearly writtern or using more words than necessary to convey information or express an idea.)
		
		obj.show();
	}

}
