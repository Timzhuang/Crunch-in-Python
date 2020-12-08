import java.nio.file.Path;

import org.apache.crunch.Pipeline;
import org.apache.crunch.PCollection;
import org.apache.crunch.impl.mem.MemPipeline;
import py4j.GatewayServer;

public class MemPipelineEntryPoint {

    private Pipeline p;

    public MemPipelineEntryPoint() {

        p = MemPipeline.getInstance();

    }

    public MemPipelineEntryPoint getInstance() {

        return new MemPipelineEntryPoint();
        // Not sure if I should initialize in constructor or??
    }

    public PCollection_ readTextFromFileWrapper() {
        return new PCollection_(p.readTextFile("/"));
    }

    // Do i have to return all the static methods, not just getInstance???
    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new MemPipelineEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }

}
