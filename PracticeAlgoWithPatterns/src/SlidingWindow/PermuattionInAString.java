package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.*/
public class PermuattionInAString {

    public static boolean containsStringPermutation(String str, String pattern) {
        boolean result = false;
        int patternIndex = 0;
        for(int i = 0; i < str.length(); i++) {
            String temp = pattern;
            if(pattern.contains(""+str.charAt(i))) {
                while(temp.contains(""+str.charAt(i))) {
                    temp = temp.replaceFirst("" + str.charAt(i), "");
                    if(patternIndex == pattern.length() - 1)
                        return true;
                    i++; patternIndex++;
                }
                patternIndex = 0;
            }
        }
        return  result;
    }

    public static boolean containsStringPermutationUsingHashMap(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        int matched = 0, windowStart =0;
        for(int i = 0; i < str.length(); i++) {
          if(map.containsKey(str.charAt(i))) {
              map.put(str.charAt(i), map.get(str.charAt(i)) -1);
              if(map.get(str.charAt(i)) == 0)
                matched++;
          }
          if(matched == map.size())
              return true;
          if(i >= pattern.length() - 1) {
              if(map.containsKey(str.charAt(windowStart))) {
                  if(map.get(str.charAt(windowStart)) == 0)
                      matched--;
                  map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) + 1);
              }
              windowStart++;
          }
        }
        return false;
    }

    public static void main(String[] args) {
       // System.out.println(containsStringPermutation("odicf", "dc"));
        //System.out.println(containsStringPermutationUsingHashMap("odicf","dc"));
        //System.out.println(containsStringPermutation("oidbcaf", "abc"));
        System.out.println(containsStringPermutationUsingHashMap("ppqp", "pq"));
    }
}
