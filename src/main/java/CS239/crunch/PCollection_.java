package src.main.java.CS239.crunch;

import org.apache.crunch.PTable;
import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.crunch.PCollection;
import org.apache.crunch.types.writable.Writables;

public class PCollection_ {

    public static PTable count(PCollection p) {
        return p.count();
    }

    public static PCollection<String> tokenize(PCollection<String> lines) {

        return lines.parallelDo(new Tokenizer(), Writables.strings());
    }

}

// Try returning a null object instead
// You basically have to create an object on the Java side, pass it to python,
// and then have the object passed back to Java for an update