package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/* if you are allowed to replace no more than ‘k’ letters with any letter,
find the length of the longest substring having the same letters after replacement.

Example 1:
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

Example 2:
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".*/
public class LongestSubstringWithSameLettersAfterReplacement {

    public static int longestSubstring(String str, int k) {
        int maxLength = Integer.MIN_VALUE;
        int maxRepeatLetterCount = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(str.charAt(i)));
            //don't have to actually replace the letters just find if there is a space for replacement for the given limit(ie k) so we can have
            //a maxLength string with max count letter.
            if(i - windowStart + 1 - maxRepeatLetterCount > k) {
                map.put(str.charAt(windowStart), map.get(str.charAt(windowStart)) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aabccbb", 2));
    }
}
