import py4j.GatewayServer;
import org.apache.crunch.Pair;
  // crunch-core/src/main/java/org/apache/crunch/Pair.java
import org.apache.crunch.Tuple3;
  // crunch-core/src/main/java/org/apache/crunch/Tuple3.java
import org.apache.crunch.Tuple4;
  // crunch-core/src/main/java/org/apache/crunch/Tuple4.java
import org.apache.crunch.TupleN;
  // crunch-core/src/main/java/org/apache/crunch/TupleN.java

public class TupleTestEntryPoint {

    private Pair my_pair;

    private TupleN my_tuple_n;

    public TupleTestEntryPoint() {
      System.out.println("Creating TupleTestEntryPoint object");
    }

    public <T, U> void makePair(T first, U second) {
      my_pair = Pair.of(first, second);
    }

    public Pair getPair() {
      return my_pair;
    }

    public Object getFirst() {
      return my_pair.first();
    }

    public Object getSecond() {
      return my_pair.second();
    }

    public <A, B, C, D, E> void makeTuple(A first, B second, 
        C third, D fourth, E fifth) {
      my_tuple_n = new TupleN(first, second, third, fourth, fifth);
    }

    public <A, B, C, D, E, F> void makeTuple(A first, B second,
        C third, D fourth, E fifth, F sixth) {
      my_tuple_n = new TupleN(first, second, third, fourth, fifth, sixth);
    }

    public TupleN getTuple() {
      return my_tuple_n;
    }

    public Object[] getTupleVals() {
      return my_tuple_n.getValues();
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer =
            new GatewayServer(new TupleTestEntryPoint());
        gatewayServer.start();
        System.out.println("GatewayServer started");
    }

}