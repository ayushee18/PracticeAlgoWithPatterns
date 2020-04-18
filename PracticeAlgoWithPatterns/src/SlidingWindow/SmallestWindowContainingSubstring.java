package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*find the smallest substring in the given string which has all the characters of the given pattern

Example 1:
Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Example 2:
Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".

Example 3:
Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.*/
public class SmallestWindowContainingSubstring {

    public static String findSubstring(String str, String pattern) {
        String result = "";
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int windowStart = 0;
        int matched = 0; int startIndex = 0, endIndex = -1, minLength = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                if(map.get(str.charAt(i)) == 0)
                    matched++;
            }

            if(matched == pattern.length() - 1) {
                if(minLength > i - windowStart + 1) {
                    minLength = i - windowStart + 1;
                    startIndex = windowStart;
                    endIndex = i;
                }
            }

            if(i >= pattern.length() - 1) {
                if(map.containsKey(str.charAt(windowStart))) {
                    if(map.get(str.charAt(windowStart)) == 0)
                        matched--;
                    map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) + 1);
                }
                windowStart++;
            }
        }
        result = str.substring(startIndex, endIndex + 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("abdabca", "abc"));
    }
}
