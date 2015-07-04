package test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import main.entity.DictionaryNumberWord;
import main.entity.NumberInWord;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class NumberInWordTest{	
	
	    private final String expected;
	    private final int input;

	    public NumberInWordTest(final String expected, final int input) {
	        this.expected = expected;
	        this.input = input;
	    }

	    @Parameters
	    public static Collection<Object[]> data() {
	        final Object[][] data = new Object[][] {
	        	{ "zero", 0 },
	        	{ "one", 1 },
		        { "one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine", 123456789 },
	            { "ten million two hundred and thirty five thousand seventy eight", 10235078 },
	            { "forty thousand one", 40001 },
	            { "sixty million seventy thousand ninety", 60070090 },
	            { "eleven million twelve thousand thirteen", 11012013 },
	            { "forteen million fifteen thousand sixteen", 14015016 },
	            { "seventeen million eighteen thousand nineteen", 17018019  },
	            { "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", 999999999 },
	            { "one million three thousand four", 1003004 },
	            { "ten million thirty thousand forty", 10030040 },
	            { "two hundred and thirty million four hundred", 230000400 },
	            { "two hundred and three million forty four thousand four", 203044004 },
	            { "two hundred million three hundred thousand four", 200300004 },
	            { "two hundred million thirty thousand four", 200030004 },
	            { "two hundred million three thousand four", 200003004 },
	            { "two hundred million three hundred and four", 200000304 },
	            { "two hundred million thirty four", 200000034 } };
	        return Arrays.asList(data);
	    }

	    @Test
	    public void test() {
	    	NumberInWord number = new NumberInWord(input, "EN");
	        assertEquals(expected, number.getTextualRepresentation());
	    }
	}
