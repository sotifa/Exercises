package main.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Catalogue {
	
	public static final String DEFAULT_LANGUAGE = "EN";
	private static Map<String, DictionaryNumberWord> dictionaries;
	
	static{
		dictionaries = new HashMap<String, DictionaryNumberWord>();
		dictionaries.put("EN", new EnDictionaryNumberWord());
		//dictionaries.put("IT", new EnDictionaryNumberWord());
	}
	
	public static DictionaryNumberWord get(String language){
		return dictionaries.get(language);
	}
	
	public static List<String> getAvailableLanguages(){
		
		List<String> languages = new ArrayList<String>();
		for(String key : dictionaries.keySet()){
			languages.add(key);
		}
		return languages;
	}
}
