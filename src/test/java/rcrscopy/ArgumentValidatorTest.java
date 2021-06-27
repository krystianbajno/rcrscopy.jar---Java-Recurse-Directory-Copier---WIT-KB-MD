package rcrscopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rcrscopy.config.ArgumentsConfig;
import rcrscopy.config.parsers.ArgumentsParser;
import rcrscopy.validators.ArgumentsValidator;

class ArgumentValidatorTest {
	
	@Test
	void validateZeroNoOfThreadsTest() throws Exception {
		ArgumentsParser parser = new ArgumentsParser(new String[] {"C:/", "C:/", "0"} );
		ArgumentsConfig config =  parser.parse();
		ArgumentsValidator validator = new ArgumentsValidator();
		
		Assertions.assertEquals("Threads count invalid", validator.validate(config));
	}
	
	@Test
	void validateInvalidSourcePathTest() throws Exception {
		ArgumentsParser parser = new ArgumentsParser(new String[] {"TEST", "C:/"} );
		ArgumentsConfig config =  parser.parse();
		ArgumentsValidator validator = new ArgumentsValidator();
		
		Assertions.assertEquals("Source file/directory is invalid", validator.validate(config));
	}
}
