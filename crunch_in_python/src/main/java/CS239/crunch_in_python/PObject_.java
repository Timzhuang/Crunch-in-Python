package CS239.crunch_in_python;

import java.util.ArrayList;
import java.util.List;

import org.apache.crunch.PObject;

public class PObject_ {
	public static List<PObject> pObjects = new ArrayList<PObject>();
	
	/*
	public static <T> T getValue_(int index) {
		PObject<T> pObj = pObjects.get(index);
		return pObj.getValue();
	}
	*/
	public static PObject getValue_(int index) {
		return pObjects.get(index);
	}
}
