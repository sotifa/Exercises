package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.entity.Catalogue;
import main.entity.NumberInWord;
import static main.entity.Message.*;

public class Translate {
	
	static String inputNumber = "";
	static int inputValue;
	static String inputLanguage = Catalogue.DEFAULT_LANGUAGE;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
		System.out.println(WELCOME + Catalogue.getAvailableLanguages()); 
		boolean continueAsking = true;
		String numberInInput = args!=null && args.length>0 ? args[0]:null;
		 
		while(continueAsking){
			
			inputValue = -1;
			continueAsking = getUserInput(br, numberInInput);
			if(numberInInput!=null && !numberInInput.isEmpty()){
				continueAsking = false;
			}
			
			if(inputValue != -1){
		        translate(inputValue, inputLanguage);
			}		
		}
	}
	
	private static void translate(int inputValue, String inputLanguage){
		
        	NumberInWord numberInWord = new NumberInWord(inputValue, inputLanguage);
        	System.out.println(numberInWord.getTextualRepresentation());
	}
	
	private static boolean getUserInput(BufferedReader br, String arg) throws IOException{
		
		if(arg != null && !arg.isEmpty()){
			inputNumber = arg;
			
		}else{
			
			System.out.println("\n"+INPUT_REQUEST+NumberInWord.MAX_VALUE);
			
			inputNumber = br.readLine();
			
			if(inputNumber.equalsIgnoreCase("E")){
				return false;
			}
			
			if(Catalogue.getAvailableLanguages().size()>1){
				
				System.out.println(LANGUAGE_REQUEST + Catalogue.DEFAULT_LANGUAGE);
				inputLanguage = br.readLine();
				if(inputLanguage.replace(" ","").isEmpty()){
					inputLanguage = Catalogue.DEFAULT_LANGUAGE;
				}
			}			
			if(inputLanguage.equalsIgnoreCase("E")){
				return false;
			}		
		}
        try{
            inputValue = Integer.parseInt(inputNumber);
            
            if(inputValue < 0 || inputValue > NumberInWord.MAX_VALUE){
            	return true;
            }            
            
        }catch(NumberFormatException nfe){
        	//just prompt again for the correct info
        	System.out.println(INVALID_NUMBER);
        	return true;
        }
        return true;
	}
}
