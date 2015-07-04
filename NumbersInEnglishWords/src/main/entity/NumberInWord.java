package main.entity;

import static main.entity.Message.*;

public class NumberInWord extends NumberInWordBuilder {
	

	public final static Integer MAX_VALUE = 999999999;
	public int value;

	private String language;	
	
	public NumberInWord(Integer inputValue, String inputLanguage){
		this.value = inputValue;
		this.language = inputLanguage;
		this.textualRepresentation = new StringBuilder();
	}

	public String getTextualRepresentation() {
		
		dictionary = Catalogue.get(language.toUpperCase());
		
		if(dictionary == null){
			return UNKNOWN_LANGUAGE;
		}else {
			textualRepresentation = buildTextualRepresentation();			
		}
		return textualRepresentation.toString();
	}
	
	protected StringBuilder buildTextualRepresentation(){
		
		if(value > 0){
			buildMillions(value);	
		}
		else{
			textualRepresentation.append(dictionary.get(value));
		}		
		return textualRepresentation;
	}
}
