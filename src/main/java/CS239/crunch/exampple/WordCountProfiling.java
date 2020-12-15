package src.main.java.CS239.crunch.exampple;

import org.junit.Test;

public class WordCountProfiling {
    @Test
    public void profileWordCount() throws Exception {
        String inputPath = "/Users/ishaanpota/Desktop/ugh/data/benchmark3.txt";
        String outputPath = "/Users/ishaanpota/Desktop/ugh/output/output3_java";

        long startTime = System.nanoTime();
        WordCount.main(new String[] { inputPath, outputPath });
        long stopTime = System.nanoTime();
        System.out.println((double) (stopTime - startTime) / 1000000000.0);
    }
}