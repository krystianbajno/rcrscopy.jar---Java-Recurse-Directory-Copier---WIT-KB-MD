package rcrscopy.config.parsers.validators;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

final public class DirectoryExistsChecker {	
	public Boolean check(File directory) {
		return directory.getParentFile().exists();
	}
}
