import py4j.GatewayServer;
import org.apache.crunch.PCollection;

public class GenericTestEntryPoint {

    public GenericTestEntryPoint() {
      System.out.println("Creating GenericTestEntryPoint object");
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer =
            new GatewayServer(new GenericTestEntryPoint());
        gatewayServer.start();
        System.out.println("GatewayServer started");
    }

}