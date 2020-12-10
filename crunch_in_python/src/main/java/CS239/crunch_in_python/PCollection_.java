package CS239.crunch_in_python;
import org.apache.crunch.PCollection;
import org.apache.crunch.types.writable.Writables;

import java.util.*;
import java.util.function.Function;

public class PCollection_ {
	
	//public static List<PCollection<String>> pCols = new ArrayList<PCollection<String>>();
	public static List<PCollection> pCols = new ArrayList<PCollection>();
	
	public static void parallelDo_(int index, Function<String, String[]> lambda) {
		
		// convert the python-side lambda wrapper to the Java-side DoFn object
		// call parallelDo with the Dofn object for the real PCollection object identified by the index
		// add the result real PCollection object to the static list
		pCols.add(pCols.get(index).parallelDo(new LambdaWrapper(lambda), Writables.strings()));	
	}
	
	public static void count_(int index) {
		// call count method for the real PCollection object identified by the index
		// add the result real PTable object to the static list
		PTable_.pTables.add(pCols.get(index).count());
	}
	
	public static void tokenize_(int index) {
		// call parallelDo with the Dofn object for the real PCollection object identified by the index
		// add the result real PCollection object to the static list
		pCols.add(pCols.get(index).parallelDo(new Tokenizer(), Writables.strings()));
	}
	
}
