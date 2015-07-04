package main.entity;
import java.util.HashMap;
import java.util.Map;


public class EnDictionaryNumberWord extends DictionaryNumberWord{
	
	private final String CONNECTOR = "and";
	private final Map<Integer,String> keyIntegers = new HashMap<Integer,String>();
	
    public EnDictionaryNumberWord(){
		keyIntegers.put(0,"zero");
		keyIntegers.put(1,"one");
		keyIntegers.put(2,"two");
		keyIntegers.put(3,"three");
		keyIntegers.put(4,"four");
		keyIntegers.put(5,"five");
		keyIntegers.put(6,"six");
		keyIntegers.put(7,"seven");
		keyIntegers.put(8,"eight");
		keyIntegers.put(9,"nine");
		keyIntegers.put(10,"ten");
		keyIntegers.put(11,"eleven");
		keyIntegers.put(12,"twelve");
		keyIntegers.put(13,"thirteen");
		keyIntegers.put(14,"forteen");
		keyIntegers.put(15,"fifteen");
		keyIntegers.put(16,"sixteen");
		keyIntegers.put(17,"seventeen");
		keyIntegers.put(18,"eighteen");
		keyIntegers.put(19,"nineteen");
		keyIntegers.put(20,"twenty");
		keyIntegers.put(30,"thirty");
		keyIntegers.put(40,"forty");
		keyIntegers.put(50,"fifty");
		keyIntegers.put(60,"sixty");
		keyIntegers.put(70,"seventy");
		keyIntegers.put(80,"eighty");
		keyIntegers.put(90,"ninety");
		keyIntegers.put(100,"hundred");
		keyIntegers.put(1000,"thousand");
		keyIntegers.put(1000000,"million");	
	}	

	public String getConnector() {
		return CONNECTOR;
	}

	public String get(Integer number) {
		return keyIntegers.get(number);
	}
}
