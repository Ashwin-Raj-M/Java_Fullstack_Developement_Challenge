import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Map;
//import java.util.TreeMap;

/**
 * 
 * Map is a key value pair collection
 * where; keys are set and does not allow duplicates
 * 		  values are list and allows duplicates
 * So essentially a map is a combination of Set and List
 * 
 * !! HashMaps and HashTables are exaclly same but HashTable is Synchronized by default !!
 * 
 * @author ashwi
 *
 */


public class Collection_Map {

	public static void main(String[] args) {

		Map <String, Integer> students = new HashMap<>();
//		Map <String, Integer> students = new Hashtable<>(); // uncomment HashTable and comment HashMap for further understanding
//		Map <String, Integer> students = new TreeMap<>(); // TreeMap will have the pairs sorted based on the keys
		
		students.put("Ashwin", 100); // Map uses a put(), method to add key value pairs
		students.put("Aparnaa", 98);
		students.put("Marimuthu", 99);
		students.put("Uma", 95);
		students.put("Ashwin", 95);
		
		System.out.println(students);
		
		System.out.println(students.get("Ashwin")); // the map will have the last updated value
		
		System.out.println(students.keySet()); // Extracts the key values alone
		
		for(String key : students.keySet()) {
			System.out.println(key + " : " + students.get(key));
		}
	}

}
