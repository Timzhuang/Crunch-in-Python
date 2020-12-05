import org.apache.crunch.Pipeline;
import org.apache.crunch.impl.mem.MemPipeline;
import py4j.GatewayServer;

public class MemPipelineEntryPoint {

    private Pipeline p;

    public MemPipelineEntryPoint() {

        p = MemPipeline.getInstance();

    }

    public Pipeline getInstance() {

        return p;
        // Not sure if I should initialize in constructor or??
    }

    // Do i have to return all the static methods, not just getInstance???
    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new MemPipelineEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }

}
