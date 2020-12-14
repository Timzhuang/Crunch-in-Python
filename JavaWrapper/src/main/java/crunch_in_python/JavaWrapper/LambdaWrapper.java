package crunch_in_python.JavaWrapper;

import java.util.function.Function;

import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;

// LambdaWrapper: a DoFn class that apply the python-side lambda expression 
public class LambdaWrapper extends DoFn<Double, Double>{
	
	private Function<Double, Double> lambda; 
	
	// initialize with the python-side lambda expression wrapper
	public LambdaWrapper(Function<Double, Double> lambda) {
		this.lambda = lambda;
	}
	
	@Override
    public void process(Double input, Emitter<Double> emitter) {
		// apply the lambda expression wrapper on the input 
		emitter.emit(lambda.apply(input));

    }
}
