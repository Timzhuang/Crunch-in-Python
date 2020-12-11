import java.nio.file.Path;

import org.apache.crunch.Pipeline;
import org.apache.crunch.PCollection;
import org.apache.crunch.impl.mem.MemPipeline;
import py4j.GatewayServer;
import org.apache.crunch.types.writable.Writables;
import java.util.function.Function;

public class MemPipelineEntryPoint {

    private Pipeline p;

    public MemPipelineEntryPoint() {

        p = MemPipeline.getInstance();

    }

    public Pipeline getInstance() {

        return p;
        // Not sure if I should initialize in constructor or??
    }

    public static PCollection<String> parallelDoWrapper(PCollection<String> lines) {

        return lines.parallelDo(new Tokenizer(), Writables.strings());
    }

    public static PCollection<String> readTextFromFileWrapper(MemPipeline p2) {
        return p2.readTextFile("report.txt");
    }

    // Do i have to return all the static methods, not just getInstance???
    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new MemPipelineEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }

}
