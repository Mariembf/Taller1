package tareafinal1;
import java.util.*;

public class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer a, Integer b) {
		return -a.compareTo(b);
	}
}