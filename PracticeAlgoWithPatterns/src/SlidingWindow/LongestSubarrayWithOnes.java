package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.

Example 1:
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

Example 2:
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.*/
public class LongestSubarrayWithOnes {
    public static int longestContiguousSubarrayWithOnes(int [] arr, int k) {
        int maxLength = Integer.MIN_VALUE;
        int maxOneCount = 0;
        int windowStart = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                maxOneCount++;
            }
            if(i - windowStart + 1 - maxOneCount > k) {
                if(arr[windowStart] == 1)
                    maxOneCount--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int [] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(longestContiguousSubarrayWithOnes(arr, 2));
        System.out.println(longestContiguousSubarrayWithOnes(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
    }
}
