package rcrscopy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
public class FileWriterHelper {
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