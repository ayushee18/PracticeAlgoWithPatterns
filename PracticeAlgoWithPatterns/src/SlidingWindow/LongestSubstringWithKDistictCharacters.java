package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring in it with no more than K distinct characters.
public class LongestSubstringWithKDistictCharacters {

    public static int longestSubstring(String str, int k){
        int maxLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                int temp = map.get(str.charAt(i));
                map.put(str.charAt(i), temp + 1);
            } else {
                map.put(str.charAt(i), 1);
            }

            while(map.size() > k) {
                if(map.containsKey(str.charAt(windowStart))) {
                    int temp = map.get(str.charAt(windowStart));
                    if(temp > 1) {
                        map.put(str.charAt(windowStart), temp - 1);
                    } else {
                        map.remove(str.charAt(windowStart));
                    }
                }
                windowStart++;
            }
            maxLength = Math.max(i - windowStart + 1, maxLength);
        }
        return  maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("araaci", 1));
    }
}
