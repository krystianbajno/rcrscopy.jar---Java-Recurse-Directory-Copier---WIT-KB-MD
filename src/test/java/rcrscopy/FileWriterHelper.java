package rcrscopy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Utility class for writing content into temporary files, used for unit testing
 * @author Mateusz Dygas
 * @author Krystian Bajno
 *
 */

public class FileWriterHelper {
	
	/**
	 * 
	 * @param path - file path
	 * @param content - content to write
	 */
    public void write(Path path, String content) {
        try {
            File file = new File(path.toUri());
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}