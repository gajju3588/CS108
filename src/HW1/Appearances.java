package HW1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b)
    {
        Map<T, Integer> mapA = new HashMap<T, Integer>();
        Map<T, Integer> mapB = new HashMap<T, Integer>();

        for (T t : a) {
            int count = 0;
            if(mapA.containsKey(t)){
                count = mapA.get(t);
            }
            count++;
            mapA.put(t,count);
        }
        for (T t : b) {
            int count = 0;
            if(mapB.containsKey(t)){
                count = mapB.get(t);
            }
            count++;
            mapB.put(t,count);
        }

        int result = 0;
        for (T key : mapA.keySet()) {
            if(mapA.get(key) == mapB.get(key)) {
                 result++;
            }
        }

        return result;
	}
	
}
