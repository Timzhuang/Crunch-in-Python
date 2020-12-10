package CS239.crunch_in_python;
import java.util.*;

import java.lang.Class;
import org.apache.crunch.PCollection;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.crunch.impl.mem.MemPipeline;

public class MemPipeline_ {
	
	private static List<Pipeline> pipelines = new ArrayList<Pipeline>();

	public static void create_MemPipeline(App app) {
		// create a read Pipeline object identified by its index
		pipelines.add(new MRPipeline(app.getClass(), app.getConf()));
	}
	
	public static void getInstance_() {
		// create a read Pipeline object identified by its index
		pipelines.add(MemPipeline.getInstance());
	}
	
	public static void readTextFile_(int index, String inputPath) {
		// call the readTextFile method for the real pipeline object identified by the index
		PCollection<String> lines = pipelines.get(index).readTextFile(inputPath);
		// add the result real PCollection object to the static list
		PCollection_.pCols.add(lines);
	}
	
	public static void writeTextFile_(int index_pipeline, int index_pTable, String outputPath) {
		// call the writeTextFile method for the real pipeline object identified by the index_pipeline
		// pass the real PTable object identified by the index_pTable to method
		pipelines.get(index_pipeline).writeTextFile(PTable_.pTables.get(index_pTable), outputPath);
	}
	
	public static void done_(int index) {
		// call the done method for the real pipeline object identified by the index
		pipelines.get(index).done();
	}
}
