package main.entity;

public class NumberInWordBuilder {
	
	protected StringBuilder textualRepresentation;
	protected DictionaryNumberWord dictionary;
	
	public final static int ONE_MILLION = 1000000;
	public final static int ONE_THOUSAND = 1000;
	public final static int ONE_HUNDRED = 100;
	public final static int TEN = 10;

	int getFactor(int digitsValue, int unit){
		return digitsValue / unit;
	}
	int getRemainder(int digitsValue, int unit){
		return digitsValue % unit;
	}
	int getPowerOfTen(int digitsValue, int factor, int remainder){
		if(factor > 0){
			return (digitsValue-remainder)/factor;
		}else{
			return 1;
		}
	}
	void appendToTextRapresentation(String substring){
		textualRepresentation.append(substring);
	}
	void appendToTextRapresentationSpaces(String substring){
		textualRepresentation.append(" ").append(substring).append(" ");
	}
	void appendToTextRapresentation(String substring1, String substring2){
		textualRepresentation.append(substring1).append(" ").append(substring2);
	}
	
	protected void buildMillions(int nineDigitValue){
		
		int factor = getFactor(nineDigitValue, ONE_MILLION);
		int remainder = getRemainder(nineDigitValue, ONE_MILLION);
		int powerOfTen = getPowerOfTen(nineDigitValue, factor, remainder);
		
		if(factor>0){
			buildHundreds(factor);
			appendToTextRapresentationSpaces(dictionary.get(powerOfTen));	
		}			
		if(remainder>0){
			buildThousands(remainder);
		}		
	}
	
	private void buildThousands(int sixDigitValue){
		
		int factor = getFactor(sixDigitValue, ONE_THOUSAND);
		int remainder = getRemainder(sixDigitValue, ONE_THOUSAND);
		int powerOfTen = getPowerOfTen(sixDigitValue, factor, remainder);
		
		if(factor>0){
			buildHundreds(factor);
			appendToTextRapresentationSpaces(dictionary.get(powerOfTen));
		}		
		if(remainder>0){
			buildHundreds(remainder);
		}
	}
	private void buildHundreds(int threeDigitValue){
		
		int factor = getFactor(threeDigitValue, ONE_HUNDRED);
		int remainder = getRemainder(threeDigitValue, ONE_HUNDRED);
		int powerOfTen = getPowerOfTen(threeDigitValue, factor, remainder);
		
		if(factor>0){
			appendToTextRapresentation(dictionary.get(factor),dictionary.get(powerOfTen));		
		}
		if(remainder>0){
			if(factor>0){
				appendToTextRapresentationSpaces(dictionary.getConnector());
			}
			buildTens(remainder);
		}
	}
	
	private void buildTens(int twoDigitValue){
		
		int factor = getFactor(twoDigitValue, TEN);
		int remainder = getRemainder(twoDigitValue, TEN);
		int factorOTen = getPowerOfTen(twoDigitValue, factor, remainder)*factor;
		
		if(factor>1){
			
			if(remainder > 0){
				appendToTextRapresentation(dictionary.get(factorOTen),dictionary.get(remainder));
			}else{
				appendToTextRapresentation(dictionary.get(factorOTen));
			}
		}else{
			appendToTextRapresentation(dictionary.get(twoDigitValue));
		}		
	}	
}
