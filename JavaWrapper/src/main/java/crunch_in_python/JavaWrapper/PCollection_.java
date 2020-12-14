package crunch_in_python.JavaWrapper;
import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.PCollection;
import org.apache.crunch.types.writable.Writables;

import java.util.*;
import java.util.function.Function;

public class PCollection_ {
	
	//public static List<PCollection<String>> pCols = new ArrayList<PCollection<String>>();
	public static List<PCollection> pCols = new ArrayList<PCollection>();
	
	public static void parallelDo_(int index, Function<Double, Double> lambda) {
		
		// convert the python-side lambda wrapper to the Java-side DoFn object
		// call parallelDo with the Dofn object for the real PCollection object identified by the index
		// add the result real PCollection object to the static list
		pCols.add(pCols.get(index).parallelDo(new LambdaWrapper(lambda), Writables.doubles()));	
	}
	
	public static void count_(int index) {
		// call count method for the real PCollection object identified by the index
		// add the result real PTable object to the static list
		PTable_.pTables.add(pCols.get(index).count());
	}
	
	public static void max_(int index) {
		// call max method for the real PCollection object identified by the index
		// add the result real PObject object to the static list
		PObject_.pObjects.add(pCols.get(index).max());
	}
	
	public static void tokenize_(int index) {
		// call parallelDo with the Dofn object for the real PCollection object identified by the index
		// add the result real PCollection object to the static list
		pCols.add(pCols.get(index).parallelDo(new Tokenizer(), Writables.strings()));
	}
	
	public static void toDouble_(int index) {
		// call parallelDo with the Dofn object for the real PCollection object identified by the index
		// add the result real PCollection object to the static list
		pCols.add(pCols.get(index).parallelDo(
				new DoFn<String, Double>() {
					public void process(String input, Emitter<Double> emitter) {
						emitter.emit(Double.parseDouble(input));
					}
				},
				Writables.doubles()));
	}
	
}
