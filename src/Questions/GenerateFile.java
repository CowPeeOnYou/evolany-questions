package Questions;

import java.io.IOException;
import java.io.RandomAccessFile;

public class GenerateFile {
    private String fileName;

    public GenerateFile(String fileName) {
        this.fileName = fileName;
    }

    // IOException
    public void generate(long size) throws IOException {
        //Check for negative numbers
        if (size <0) return;
        // Create file using RandomAccessFile class
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        try {
            // since size is in megabytes
            raf.setLength(size * 1024);
        } catch (Exception e) {
            System.out.println("Something is wrong");
        } finally {
            raf.close();
            System.out.println("Created a file of size: " + size + " MB and name of " + fileName);
        }
    }

}
