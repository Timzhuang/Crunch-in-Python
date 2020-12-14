package crunch_in_python.JavaWrapper;
import java.util.function.Function;
import py4j.GatewayServer;

public class LambdaConversionTest {
	public static String callFunction(Function<Integer, String> function) {
        return function.apply(42);
    }
	
	public static String[] callFunction2(Function<String, String[]> function) {
        return function.apply("a b c");
    }
	
public static void main(String[] args) {
		
		LambdaConversionTest app = new LambdaConversionTest();
	    //app is now the gateway.entry_point
	    GatewayServer server = new GatewayServer(app);
	    server.start();
	}
	
}
