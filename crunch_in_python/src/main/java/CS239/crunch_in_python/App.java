package CS239.crunch_in_python;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import py4j.GatewayServer;

/**
 * need to debug: use JavaEntryPoint instead!
 *
 */
public class App extends Configured implements Tool
{
    public static void main( String[] args ) throws Exception
    {
    	ToolRunner.run(new Configuration(), new App(), args);
    }
    
    public int run(String[] args) throws Exception {
    	
    	//App app = new App();
	    //app is now the gateway.entry_point
	    GatewayServer server = new GatewayServer(new App());
	    server.start();
	    System.out.println("good!");
    	return 0;
    }
    
    // a wrapper method for the create_MemPipeline method in the MemPipeline_ wrapper class
    public void create_MemPipeline() {
    	MemPipeline_.create_MemPipeline(this);
    }
    
    
}
