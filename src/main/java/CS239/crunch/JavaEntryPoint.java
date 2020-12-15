package src.main.java.CS239.crunch;

import py4j.GatewayServer;

public class JavaEntryPoint {

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new JavaEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }

}