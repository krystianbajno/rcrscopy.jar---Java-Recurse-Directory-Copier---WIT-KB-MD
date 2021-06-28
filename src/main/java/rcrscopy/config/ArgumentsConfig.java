package rcrscopy.config;

import java.io.File;

/**
 * ValueObject containing configuration for fileSource, fileDestination, threadsCount
 * @author Krystian Bajno
 * @author Mateusz Dygas
 *
 */
public class ArgumentsConfig {
    private Integer threadsCount;
    private File source;
    private File destination;
    
    /**
     * 
     * @param source - ssource path
     * @param destination - target path 
     * @param threadsCount - number of threads for files copy process
     */
    public ArgumentsConfig(
        File source,
        File destination,
        Integer threadsCount
    ) { 
        this.source = source;
        this.destination = destination;
        this.threadsCount = threadsCount;
    }
    
    /**
     * @return Integer
     */
    public Integer getThreadsCount() {
        return threadsCount;
    }
    
    /**
     * @return File
     */
    public File getSource() {
        return source;
    }
    
    /**
     * @return File
     */
    public File getDestination() {
        return destination;
    }
}
