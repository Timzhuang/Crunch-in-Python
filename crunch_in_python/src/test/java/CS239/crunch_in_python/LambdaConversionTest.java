package CS239.crunch_in_python;
import java.util.function.Function;
import py4j.GatewayServer;

public class LambdaConversionTest {
	public static String callFunction(Function<Integer, String> function) {
        return function.apply(42);
    }
	
public static void main(String[] args) {
		
		LambdaConversionTest app = new LambdaConversionTest();
	    //app is now the gateway.entry_point
	    GatewayServer server = new GatewayServer(app);
	    server.start();
	}
	
}
