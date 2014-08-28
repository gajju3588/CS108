package HW1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {

        if(str == null || str.length() ==0){
            return 0;
        }

        int max =0,current =1;
        char currentCh = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {

            if(str.charAt(i) == currentCh){
                 current++;
            }
            else
            {
                if(current > max){
                    max = current;
                }
                current = 1;
                currentCh=str.charAt(i);
            }
        }
        return max;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                if(i+1 < str.length()) {
                    for (int j = 0; j < (str.charAt(i) - 48); j++) {
                        newString.append(str.charAt(i + 1));
                    }
                }

            }
            else {
                newString.append(str.charAt(i));
            }
        }
        return String.valueOf(newString);
    }
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        if(a.length() < len || b.length() < len){
            return false;
        }
        if(len <=0){
            return false;
        }
        Set<String> setA = new HashSet<String>();
        for (int i = 0; i < a.length() - len; i++) {
            setA.add(a.substring(i,i+len));
        }
        for (int i = 0; i < b.length() - len; i++) {
            if(setA.contains(b.substring(i,i+len))){
                return true;
            }
        }
        return false;
    }
}
