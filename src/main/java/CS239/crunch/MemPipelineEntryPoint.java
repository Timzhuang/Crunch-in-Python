package src.main.java.CS239.crunch;

import org.apache.crunch.Pipeline;
import org.apache.crunch.PCollection;
import org.apache.crunch.PTable;
import org.apache.crunch.impl.mem.MemPipeline;
import org.apache.crunch.io.To;

public class MemPipelineEntryPoint {

    private static Pipeline p;

    public MemPipelineEntryPoint() {

    }

    public static Pipeline getInstance() {

        p = MemPipeline.getInstance();

        return p;
        // Not sure if I should initialize in constructor or??
    }

    public static PCollection<String> readTextFromFileWrapper(MemPipeline p2, String inputPath) {
        return p2.readTextFile(inputPath);
    }

    public static void writeToFile(PTable p, String outputPath) {

        p.write(To.textFile(outputPath));

    }

    public static void done(MemPipeline p) {

        p.done();
    }

}
