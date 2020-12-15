package src.main.java.CS239.crunch.exampple;

import src.main.java.CS239.crunch.*;

import org.apache.crunch.PCollection;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.impl.mem.MemPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {

    public static int main(String[] args) throws Exception {

        // parse input
        if (args.length != 2) {
            System.err.println("require inputPath and outputPath\n");
            System.err.println();
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        // Create and Configure Data Pipeline
        Pipeline pipeline = MemPipeline.getInstance();

        // Reference a given text file as a collection of Strings.
        PCollection lines = pipeline.readTextFile(inputPath);

        // Define a function that splits each line in a PCollection of Strings into
        // a PCollection made up of the individual words in the file.
        // The second argument sets the serialization format.
        PCollection words = lines.parallelDo(new Tokenizer(), Writables.strings());

        // The count method applies a series of Crunch primitives and returns
        // a map of the unique words in the input PCollection to their counts.
        PTable counts = words.count();

        // Instruct the pipeline to write the resulting counts to a text file.
        pipeline.writeTextFile(counts, outputPath);

        // Execute the pipeline as a MapReduce.
        PipelineResult result = pipeline.done();

        return 0;

    }
}
