package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a string and a pattern, find all anagrams of the pattern in the given string.

Example 1:
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Example 2:
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".*/
public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int patternIndex = 0;
        for(int i = 0; i < str.length(); i++) {
            String temp = pattern;
            if(pattern.contains(""+str.charAt(i))) {
                while(i < str.length() && temp.contains(""+str.charAt(i))) {
                    char track = str.charAt(i);
                    temp = temp.replaceFirst(""+str.charAt(i), "");
                    if(patternIndex == pattern.length() - 1) {
                        resultIndices.add(i - (pattern.length() - 1));
                        i = i - (pattern.length() - 1) + 1;
                    } else {
                        i++;
                        patternIndex++;
                    }
                }
                i--;
                patternIndex = 0;
            }
        }
        return resultIndices;
    }

    public static List<Integer> findStringAnagramsUsingHashMap(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int windowStart = 0;
        int matchedCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                if(map.get(str.charAt(i)) == 0)
                    matchedCount++;
            }

            if(matchedCount == map.size()) {
                resultIndices.add(windowStart);
            }

            if(i >= pattern.length() - 1) {
                if(map.containsKey(str.charAt(windowStart))) {
                    if(map.get(str.charAt(windowStart)) == 0)
                        matchedCount--;
                    map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) + 1);
                }
                windowStart++;
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = findStringAnagrams("ppqp","pq");
        result = findStringAnagramsUsingHashMap("abbcabc","abc");
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+" ");
        }
    }
}
