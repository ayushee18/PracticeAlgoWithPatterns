package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*Given a string, find the length of the longest substring which has no repeating characters.

Example 1:
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Example 2:
Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
*/
public class NoRepeatSubstring {

    //Method1 - Here we are storing character frequecny in hashmap and if value of a key is greter than 1 shrink window size
    public static String longestSubstringWithNoRepeatingCharacters(String str) {
        int maxLength = Integer.MIN_VALUE;
        String result = "";
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                while (!(str.charAt(windowStart) == str.charAt(i))) {
                    map.remove(str.charAt(windowStart));
                    windowStart++;
                }
                windowStart++;
            }
            if(maxLength < i - windowStart + 1) {
                result = str.substring(windowStart, i + 1);
                maxLength = i - windowStart + 1;
            }
        }
        return  result;
        //return maxLength;
    }

    //Method2 - Here we are storing index in hashmap and if character repeats shrink the size of the map
    public static String longestSubstringWithNoRepeatingCharactersMethod2(String str) {
        int maxLength = Integer.MIN_VALUE;
        String result = "";
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                windowStart = Math.max(windowStart, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            //maxLength = Math.max(maxLength, i - windowStart + 1);
            if(maxLength < i - windowStart + 1) {
                result = str.substring(windowStart, i + 1);
                maxLength = i - windowStart + 1;
            }
        }
        return  result;
        //return maxLength;
    }

    public static void main(String[] args) {
        String str1 = "aaccbbabc";
        System.out.print(longestSubstringWithNoRepeatingCharacters(str1));
        System.out.println(" " + longestSubstringWithNoRepeatingCharactersMethod2(str1));
        String str2 = "aabccbb";
        System.out.print(longestSubstringWithNoRepeatingCharacters(str2));
        System.out.println(" " + longestSubstringWithNoRepeatingCharactersMethod2(str2));
        String str3 = "abbbb";
        System.out.print(longestSubstringWithNoRepeatingCharacters(str3));
        System.out.println(" " + longestSubstringWithNoRepeatingCharactersMethod2(str3));
        String str4 = "abccde";
        System.out.print(longestSubstringWithNoRepeatingCharacters(str4));
        System.out.println(" " + longestSubstringWithNoRepeatingCharactersMethod2(str4));
    }
}
