package SlidingWindow;

//Given an array of positive numbers and a positive number ‘S’, find the length of the smallest
// contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
public class SmallestSubArrayWithGivenSum {

    public static int shortestSubarrayWithSumEqualOrGreater(int[] arr, int target) {
        int shortestLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for(int i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
                while (sum >= target) {
                    shortestLength = Math.min(shortestLength, i - start + 1);
                    sum = sum - arr[start];
                    start++;
                }
        }

        return  shortestLength;
    }

    public static void main(String[] args) {
        int result = shortestSubarrayWithSumEqualOrGreater(new int[] { 2, 1, 5, 2, 3, 2 }, 7);
        System.out.println("Smallest subarray length: " + result);
        result = shortestSubarrayWithSumEqualOrGreater(new int[] { 2, 1, 5, 2, 8 }, 7);
        System.out.println("Smallest subarray length: " + result);
        result = shortestSubarrayWithSumEqualOrGreater(new int[] { 3, 4, 1, 1, 6 }, 8);
        System.out.println("Smallest subarray length: " + result);
    }
}
