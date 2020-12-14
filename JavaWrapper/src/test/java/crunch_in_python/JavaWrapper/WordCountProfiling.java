package crunch_in_python.JavaWrapper;

import org.junit.Test;
import crunch_in_python.JavaWrapper.example.wordCount.*;

public class WordCountProfiling {
	@Test
    public void profileWordCount() throws Exception
    {
		String inputPath = "C:\\Users\\Tim\\Documents\\cs_239_big_data_system\\crunch_in_python\\data\\benchmark1.txt";
		String outputPath = "C:\\Users\\Tim\\Documents\\cs_239_big_data_system\\crunch_in_python\\output\\java";
		
		long startTime = System.nanoTime(); 
		WordCount.main(new String[] {inputPath, outputPath});  
		long stopTime = System.nanoTime();
		System.out.println((double)(stopTime - startTime) / 1000000000.0);
    }
}
