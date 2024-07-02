package collections;


import java.util.*;

public class HashMapEx {
	public static void main(String[] args) {
//		gettingStarted();
storeObjectsInMapPreJDK5();
//		contryCodesTreeMap();
	}

	private static void gettingStarted() {
		// check for null key and values
		Map<String, Integer> countryCodesMap = new HashMap<String, Integer>();
//		Map<String, Integer> countryCodesMap = new TreeMap<String, Integer>();
		System.err.println(countryCodesMap.isEmpty());
		countryCodesMap.put("America", 00);
		countryCodesMap.put("Singapore", 65);
		countryCodesMap.put("India", 91);
		countryCodesMap.put("Japan".toUpperCase(),81);
		countryCodesMap.put("japan".toUpperCase(),81);
		countryCodesMap.put("jaPAN",81);
		countryCodesMap.put("jaPAN", 91);
		System.err.println(countryCodesMap);
		System.err.println(countryCodesMap.size());
		// search
		boolean keyFound = countryCodesMap.containsKey("Singapore");
		if(keyFound) {
			System.err.println("Singapore in the map");
		}
		else {
			System.err.println("Singapore not in the map");
		}
//		short hand ternary operation ?:
//		String valueFoundString = countryCodesMap.containsValue(65)? "65 found for Singapore" : "65 not found for Singapore";
//		System.err.println(valueFoundString);
		
//		shorter
		System.err.println(countryCodesMap.containsValue(65)? "65 found for Singapore" : "65 not found for Singapore");
		countryCodesMap.remove("Japan");
		System.err.println(countryCodesMap);
		countryCodesMap.clear();
		System.err.println(countryCodesMap);
	}
	
	private static void storeObjectsInMapPreJDK5() {
		System.out.println("Different kinds of Objects in Map");
//		Map is a raw type holds objects
		Map mapOfObjects = new HashMap();
		String objectString = "Object String";
		Integer objectInteger = 1;
		mapOfObjects.put(objectInteger, objectString);
		mapOfObjects.put(2, new Exception());
		Map insideMapValue = new HashMap<>();
		insideMapValue.put("country", "Singapore");
		mapOfObjects.put("insideMapKey", insideMapValue);
		Map insideMapKey = new HashMap<>();
		insideMapKey.put("city", "New York");
		mapOfObjects.put(insideMapKey, "insideMapValue");
		System.err.println(mapOfObjects);
		
		Collection shoppingCart = new ArrayList();
		shoppingCart.add("The Monk");
		shoppingCart.add("To Kill A Mockingbird");

		mapOfObjects.put(3, shoppingCart);
		mapOfObjects.put(shoppingCart, 4);
//		{1=Object String, 2=java.lang.Exception, 3=[The Monk, To Kill A Mockingbird], [The Monk, To Kill A Mockingbird]=4}
		System.err.println(mapOfObjects);
//		Map <String,String>dictionaryMap = new HashMap<String,String>();
	}
	private static void storeObjectsInMapJDK5Onwards() {
//		Generic Types / Type Safe collections
		System.out.println("Different kinds of Objects in Map");
//		Map is a raw type holds objects
		Map<String,Integer> mapOfObjects = new HashMap<String,Integer>();
		String objectString = "Object String";
		Integer objectInteger = 1;
//		The method put(String, Integer) in the type Map<String,Integer> is not applicable for the arguments (Integer, String)
//		mapOfObjects.put(objectInteger, objectString);
//		mapOfObjects.put(2, new Exception());
		System.err.println(mapOfObjects);
		Map<Object,Object> mapOfObjects2 = new HashMap<>();
		Map insideMapValue = new HashMap<>();
		insideMapValue.put("country", "Singapore");
		mapOfObjects2.put("insideMapKey", insideMapValue);
		Map insideMapKey = new HashMap<>();
		insideMapKey.put("city", "New York");
		mapOfObjects2.put(insideMapKey, "insideMapValue");
	}
	private static void contryCodes() {
	
		System.out.println("");
//		Map is a generic  type holds <String,Integer> 
		Map<String, Integer> countryCodes = new HashMap<String, Integer>();
//		The method put(String, Integer) in the type Map<String,Integer> is not applicable for the arguments (int, String)
//		countryCodes.put(81, "Japan");
//		The method put(String, Integer) in the type Map<String,Integer> is not applicable for the arguments (Exception, int)
//		countryCodes.put(new Exception(), 1);
		System.err.println(countryCodes.isEmpty());
		countryCodes.put("Japan", 81);
		System.err.println(countryCodes.isEmpty());
		countryCodes.put("India", 91);
		countryCodes.put("France", 0);
//		no duplicate key allowed
		countryCodes.put("France", 33);
		// duplicate values allowed
		countryCodes.put("nocounty", 33);
		System.out.println(countryCodes);
		System.err.println(countryCodes.size());
//		countryCodes.clear();
		System.out.println(countryCodes);
		String searchKeyString = countryCodes.containsKey("France") ? "KeyFound" : "KNotFound";
		System.out.println(searchKeyString);
		System.out.println(countryCodes.containsValue(33) ? "VF" : "VNF");
	}

	private static void contryCodesTreeMap() {
		System.out.println("");
//		Map is a generic  type holds <String,Integer> 
		Map<String, Integer> countryCodes = new TreeMap<String, Integer>();
//		The method put(String, Integer) in the type Map<String,Integer> is not applicable for the arguments (int, String)
//		countryCodes.put(81, "Japan");
//		The method put(String, Integer) in the type Map<String,Integer> is not applicable for the arguments (Exception, int)
//		countryCodes.put(new Exception(), 1);
		System.err.println(countryCodes.isEmpty());
		countryCodes.put("Japan", 81);
		System.err.println(countryCodes.isEmpty());
		countryCodes.put("India", 91);
		countryCodes.put("France", 0);
//		no duplicate key allowed
		countryCodes.put("France", 33);
		// duplicate values allowed
		countryCodes.put("nocounty", 33);
		System.out.println(countryCodes);
		System.err.println(countryCodes.size());
//		countryCodes.clear();
		System.out.println(countryCodes);
		String searchKeyString = countryCodes.containsKey("France") ? "KeyFound" : "KNotFound";
		System.out.println(searchKeyString);
		System.out.println(countryCodes.containsValue(33) ? "VF" : "VNF");
	}
}
