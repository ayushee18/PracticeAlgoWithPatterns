package SlidingWindow;

//Given an array, find the average of all contiguous subarrays of size 'K' in it.
public class AverageOfContinousSubarrays {

    public static double [] sumOfContinousSubarray(int [] arr, int subArrayLen) {
        double[] result = new double [arr.length - subArrayLen + 1];
        int startIndex = 0;
        double sum = 0;
        for( int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if(i - startIndex == subArrayLen - 1) {
                result[startIndex] = sum / subArrayLen;
                sum = sum - arr[startIndex];
                startIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2};
        double [] result = sumOfContinousSubarray(arr, 5);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
