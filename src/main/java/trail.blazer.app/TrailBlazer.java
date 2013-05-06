package trail.blazer.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrailBlazer implements Iterable<String>{
    List<String> theTrail = new ArrayList<String>();

    public TrailBlazer addThis(String toAddTo) {
        this.theTrail.add(toAddTo); return this;
    }

    @Override
    public Iterator<String> iterator() {
        return theTrail.iterator();
    }

    public boolean isEmpty() {
        return theTrail.isEmpty();
    }
}
