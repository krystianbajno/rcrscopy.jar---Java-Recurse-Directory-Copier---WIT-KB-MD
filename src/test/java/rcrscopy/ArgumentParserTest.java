package rcrscopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.exceptions.InvalidArgumentsException;

class ArgumentParserTest {

	@Test
	void noArgumentsForParserTest()  {
		ArgumentsParser parser = new ArgumentsParser(new String[] {} );
		
		Assertions.assertThrows(InvalidArgumentsException.class, () -> {
		    ArgumentsConfig config =  parser.parse();
		  });
	}
	
	@Test
	void nonNumericalValueOfThreadsForParserTest() throws Exception  {
		ArgumentsParser parser = new ArgumentsParser(new String[] {"C:/", "C:/", "TEST"} );
		ArgumentsConfig config =  parser.parse();
		
		Assertions.assertEquals(10, config.getThreadsCount());
	}
	
	@Test
	void noValueOfThreadsForParserTest() throws Exception  {
		ArgumentsParser parser = new ArgumentsParser(new String[] {"C:/", "C:/" } );
		ArgumentsConfig config =  parser.parse();
		
		Assertions.assertEquals(10, config.getThreadsCount());
	}
	
	@Test
	void valueOfThreadsForParserTest() throws Exception  {
		ArgumentsParser parser = new ArgumentsParser(new String[] {"C:/", "C:/" , "5"} );
		ArgumentsConfig config =  parser.parse();
		
		Assertions.assertEquals(5, config.getThreadsCount());
	}
}
