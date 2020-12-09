package CS239.crunch_in_python;

import java.util.function.Function;

import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;

// LambdaWrapper: a DoFn class that apply the python-side lambda expression 
public class LambdaWrapper extends DoFn<String, String>{
	
	// !!! str.split() does not work !!!
	private Function<String, String[]> lambda; 
	
	// initialize with the python-side lambda expression wrapper
	public LambdaWrapper(Function<String, String[]> lambda) {
		this.lambda = lambda;
	}
	
	@Override
    public void process(String line, Emitter<String> emitter) {
		// apply the lambda expression wrapper on the input 
        for (String word : lambda.apply(line)) {
            emitter.emit(word);
        }
    }
}
