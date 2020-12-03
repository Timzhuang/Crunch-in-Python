import py4j.GatewayServer;
import org.apache.crunch.PCollection;

public class CrunchEntryPoint {

    PCollection<String> lines;

    public CrunchEntryPoint() {
      System.out.println("Creating CrunchEntryPoint object");
    }

    public int return3() {
        System.out.println("Returning 3 to Python client");
        return 3;
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer =
            new GatewayServer(new CrunchEntryPoint());
        gatewayServer.start();
        System.out.println("GatewayServer started");
    }

}